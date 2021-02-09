package com.ideaas.services.dao;

import com.ideaas.services.bean.DateTimeUtil;
import com.ideaas.services.domain.MapPoi;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.domain.MapUbicacionActEspecial;
import com.ideaas.services.domain.MapUbicacionActualizacion;
import com.ideaas.services.request.MapPoiRequest;
import com.ideaas.services.request.MapUbiActEspecialRequest;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.request.UbicacionActualizacionRequest;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@SuppressWarnings("Duplicates")
@Repository
public class FilterDaoImpl implements FilterDao {

    private static final String WHERE = " WHERE ";

    private static final String AND = " AND ";

    private static final String IN = " IN ";

    private static final String PREFIX_PARAMETER = ":";

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGTH_PARENTHESIS = ")";

    private String where(){
        return WHERE;
    }


    private String and(){
        return AND;
    }

    private String in(){
        return IN;
    }

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<MapUbicacion> find(MapUbicacionRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("select u from MapUbicacion u ");
        boolean isFirstClause = true;


        if(Objects.nonNull(request.getMapEmpresa()) && !request.getMapEmpresa().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapEmpresa.descripcion in (:mapEmpresa)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapElemento()) && !request.getMapElemento().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapElemento.descripcion in (:mapElemento)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapFormato()) && !request.getMapFormato().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapFormato.descripcion in (:mapFormato)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapMedio()) && !request.getMapMedio().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapMedio.descripcion in (:mapMedio)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapProvincia()) && !request.getMapProvincia().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.mapProvincia.descripcion in (:mapProvincia)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapLocalidad()) && !request.getMapLocalidad().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.mapLocalidad.descripcion in (:mapLocalidad)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getBajaLogica()) && !request.getBajaLogica().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.bajaLogica in (:bajaLogica)");

            isFirstClause = false;
        }
        //TODO Revisar
        if(Objects.nonNull(request.getLatLngEmpty()) && !request.getLatLngEmpty().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());

            if(request.getLatLngEmpty().equals("true")){
                builder.append(" (u.latitud is null or u.longitud is null)");
            }
            else{
                builder.append(" (u.latitud is not null or u.longitud is not null)");
            }

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getFechaAlta())){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.fechaAlta between :fechaAltaStart and :fechaAltaEnd");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getIdsSelected())){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.id in (:ids)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getIdsSearch()) && !request.getIdsSearch().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.id in (:idsSearch)");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getSearchValue()) && !request.getSearchValue().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" (u.direccion LIKE :searchValue OR u.mapUbicacionAltura.descripcion LIKE :searchValue OR u.mapUbicacionVisibilidad.descripcion LIKE :searchValue OR u.idReferencia LIKE :searchValue)");
        }

        Query query = entityManager.createQuery(builder.toString());

        if(Objects.nonNull(request.getMapEmpresa()) && !request.getMapEmpresa().trim().isEmpty()){
            query.setParameter("mapEmpresa", Arrays.asList(request.getMapEmpresa().split(",")));
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
        if(Objects.nonNull(request.getMapLocalidad()) && !request.getMapLocalidad().trim().isEmpty()){
            query.setParameter("mapLocalidad", Arrays.asList(request.getMapLocalidad().split(",")));
        }
        //TODO Revisar
        if(Objects.nonNull(request.getBajaLogica()) && !request.getBajaLogica().trim().isEmpty()){
            List<String> StringList = Arrays.asList(request.getBajaLogica().split("\\s*,\\s*"));
            List<Boolean> bajaLogica = new ArrayList<>();

            for(String s : StringList) bajaLogica.add(Boolean.valueOf(s));

            query.setParameter("bajaLogica", bajaLogica);
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
        if(Objects.nonNull(request.getIdsSelected())){
            query.setParameter("ids", request.getIdsSelected());
        }
        //TODO Revisar
        if(Objects.nonNull(request.getIdsSearch()) && !request.getIdsSearch().isEmpty()){
            List<String> idsString = Arrays.asList(request.getIdsSearch().split("\\s*,\\s*"));
            List<Long> idsSearch = new ArrayList<>();

            for(String s : idsString) idsSearch.add(Long.valueOf(s));

            query.setParameter("idsSearch", idsSearch );
        }
        if(Objects.nonNull(request.getSearchValue()) && !request.getSearchValue().isEmpty()){
            query.setParameter("searchValue",  "%"+request.getSearchValue()+"%");
        }
        if(getAllResults(request)){
            Integer maxResults = Integer.valueOf(request.getMaxResults());

            query.setMaxResults(maxResults);
            query.setFirstResult(request.getPage() * maxResults);
        }

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

    @Override
    public List<MapUbicacionActualizacion> find(UbicacionActualizacionRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("select u from MapUbicacionActualizacion u ");
        boolean isFirstClause = true;
        boolean isLastClause = false;

        if(Objects.nonNull(request.getIdsSearch()) && !request.getIdsSearch().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.id.mapUbicacionId in (:idsSearch)");

            isFirstClause = false;
        }

        isLastClause = true;

        if(isLastClause){
            builder.append("order by u.id.mapUbicacionId desc");
        }

        Query query = entityManager.createQuery(builder.toString());

        if(Objects.nonNull(request.getIdsSearch()) && !request.getIdsSearch().isEmpty()){
            List<String> idsString = Arrays.asList(request.getIdsSearch().split("\\s*,\\s*"));
            List<Long> idsSearch = new ArrayList<>();

            for(String s : idsString) idsSearch.add(Long.valueOf(s));

            query.setParameter("idsSearch", idsSearch );
        }
        if(getAllResultsUbiActualizacion(request)){
            Integer maxResults = Integer.valueOf(request.getMaxResults());

            query.setMaxResults(maxResults);
            query.setFirstResult(request.getPage() * maxResults);
        }

        return query.getResultList();
    }

    @Override
    public List<MapUbicacionActEspecial> find(MapUbiActEspecialRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("select u from MapUbicacionActEspecial u ");
        boolean isFirstClause = true;
        boolean isLastClause = false;

        if(Objects.nonNull(request.getIdsSearch()) && !request.getIdsSearch().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.id.mapUbicacionId in (:idsSearch)");

            isFirstClause = false;
        }

        isLastClause = true;

        if(isLastClause){
            builder.append("order by u.id.mapUbicacionId desc");
        }

        Query query = entityManager.createQuery(builder.toString());

        if(Objects.nonNull(request.getIdsSearch()) && !request.getIdsSearch().isEmpty()){
            List<String> idsString = Arrays.asList(request.getIdsSearch().split("\\s*,\\s*"));
            List<Long> idsSearch = new ArrayList<>();

            for(String s : idsString) idsSearch.add(Long.valueOf(s));

            query.setParameter("idsSearch", idsSearch );
        }
        if(getAllResultsUbiActEspecial(request)){
            Integer maxResults = Integer.valueOf(request.getMaxResults());

            query.setMaxResults(maxResults);
            query.setFirstResult(request.getPage() * maxResults);
        }

        return query.getResultList();
    }

    @Override
    public List<MapPoi> find(MapPoiRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("select u from MapPoi u ");
        boolean isFirstClause = true;

        if(Objects.nonNull(request.getMapPoiEntidad()) && !request.getMapPoiEntidad().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapPoiEntidad.descripcion in (:mapPoiEntidad)");

            isFirstClause = false;
        }

        Query query = entityManager.createQuery(builder.toString());

        if(Objects.nonNull(request.getMapPoiEntidad()) && !request.getMapPoiEntidad().trim().isEmpty()){
            query.setParameter("mapPoiEntidad", Arrays.asList(request.getMapPoiEntidad().split(",")));
        }
        if(getAllResultsMapPoi(request)){
            Integer maxResults = Integer.valueOf(request.getMaxResults());

            query.setMaxResults(maxResults);
            query.setFirstResult(request.getPage() * maxResults);
        }

        return query.getResultList();
    }

    public Boolean getAllResults(MapUbicacionRequest request){
        return !request.getMaxResults().equals("-1");
    }

    public Boolean getAllResultsUbiActualizacion(UbicacionActualizacionRequest request){
        return !request.getMaxResults().equals("-1");
    }

    public Boolean getAllResultsUbiActEspecial(MapUbiActEspecialRequest request){
        return !request.getMaxResults().equals("-1");
    }

    public Boolean getAllResultsMapPoi(MapPoiRequest request){
        return !request.getMaxResults().equals("-1");
    }
}
