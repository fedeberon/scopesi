package com.ideaas.services.dao;

import com.ideaas.services.bean.DateTimeUtil;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class FilterDaoImpl implements FilterDao {

    private static final String WHERE = " WHERE ";

    private static final String AND = " AND ";

    private static final String IN = " IN ";

    private static final String PREFIX_PARAMETER = ":";

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGTH_PARENTHESIS = ")";

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<MapUbicacion> find(MapUbicacionRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("select u from MapUbicacion u ");
        boolean isFirstClause = true;


        if(Objects.nonNull(request.getAudEmpresa()) && !request.getAudEmpresa().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.audEmpresa.descripcion in (:audEmpresa)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapElemento()) && !request.getMapElemento().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapElemento.descripcion in (:mapElemento)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapFormato()) && !request.getMapFormato().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapFormato.descripcion = :mapFormato");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapMedio()) && !request.getMapMedio().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapMedio.descripcion = :mapMedio");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapProvincia()) && !request.getMapProvincia().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.mapProvincia.descripcion = :mapProvincia");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getAudLocalidad()) && !request.getAudLocalidad().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.audLocalidad.descripcion = :audLocalidad");

        }
        if(Objects.nonNull(request.getFechaAlta())){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.fechaAlta between :fechaAltaStart and :fechaAltaEnd");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getBajaLogica())){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.bajaLogica = :bajaLogica");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getLangLongEmpty()) && request.getLangLongEmpty() == true){
            builder.append(isFirstClause ? where() : and());
            builder.append(" (u.latitud is null or u.longitud is null)");


        }


        Query query = entityManager.createQuery(builder.toString());
        if(Objects.nonNull(request.getAudEmpresa()) && !request.getAudEmpresa().trim().isEmpty()){
            query.setParameter("audEmpresa", Arrays.asList(request.getAudEmpresa().split(",")));
        }
        if(Objects.nonNull(request.getMapElemento()) && !request.getMapElemento().trim().isEmpty()){
            query.setParameter("mapElemento", Arrays.asList(request.getMapElemento().split(",")));
        }
        if(Objects.nonNull(request.getMapFormato()) && !request.getMapFormato().trim().isEmpty()){
            query.setParameter("mapFormato", Arrays.asList(request.getMapFormato().split(",")));
        }
        if(Objects.nonNull(request.getMapMedio()) && !request.getMapMedio().trim().isEmpty()){
            query.setParameter("mapMedio", Arrays.asList(request.getMapMedio().split(",")));
        }
        if(Objects.nonNull(request.getMapProvincia()) && !request.getMapProvincia().trim().isEmpty()){
            query.setParameter("mapProvincia", Arrays.asList(request.getMapProvincia().split(",")));
        }
        if(Objects.nonNull(request.getAudLocalidad()) && !request.getAudLocalidad().trim().isEmpty()){
            query.setParameter("audLocalidad", Arrays.asList(request.getAudLocalidad().split(",")));
        }
        if(Objects.nonNull(request.getFechaAlta())){
            LocalDateTime  dateToSearch = DateTimeUtil.convertToLocalDateTimeViaSqlTimestamp(request.getFechaAlta());
            LocalDate localDate = DateTimeUtil.convertToLocalDateViaInstant(request.getFechaAlta());
            LocalDateTime startOfDay = localDate.atStartOfDay();
            LocalDateTime endOfDate = dateToSearch.toLocalDate().atTime(LocalTime.MAX);

            builder.append(" u.fechaAlta between :fechaAltaStart and :fechaAltaEnd");
            query.setParameter("fechaAltaStart", startOfDay);
            query.setParameter("fechaAltaEnd", endOfDate);
        }
        if(Objects.nonNull(request.getBajaLogica())){
            query.setParameter("bajaLogica", Arrays.asList(request.getBajaLogica()));
        }


        query.setMaxResults(10);
        query.setFirstResult(request.getPage() * 10);

        return query.getResultList();
    }

    @Override
    public List<MapUbicacion> filterSearchUbicacion(Map<String, String> clauses){
        StringBuilder builder = new StringBuilder();
        builder.append("select u from MapUbicacion u ");
        builder.append("where 1 = 1");

        clauses.forEach((k, v) -> {
            if(Objects.isNull(v) || v.isEmpty()) return;
            String nameParameter = LEFT_PARENTHESIS.concat(PREFIX_PARAMETER.concat(k)).concat(RIGTH_PARENTHESIS).replace(".","");
            builder.append(AND);
            builder.append(k).append(in()).append(nameParameter);

        });

        Query query = entityManager.createQuery(builder.toString());
        clauses.forEach((k, v) -> {
            if(Objects.isNull(v) || v.isEmpty()) return;
            String nameParameter = k.replace(".","");
            query.setParameter(nameParameter, Arrays.asList(v.split(",")));
        });

        return query.getResultList();
    }


    private String where(){
        return WHERE;
    }


    private String and(){
        return AND;
    }

    private String in(){
        return IN;
    }


}
