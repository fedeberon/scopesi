package com.ideaas.services.dao;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@Repository
public class FilterDaoImpl implements FilterDao {

    private static final String WHERE = " WHERE ";

    private static final String AND = " AND ";

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<MapUbicacion> find(MapUbicacionRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("select u from MapUbicacion u ");
        boolean isFirstClause = true;


        if(Objects.nonNull(request.getAudEmpresa()) && !request.getAudEmpresa().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.audEmpresa.descripcion = :audEmpresa");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapElemento()) && !request.getMapElemento().trim().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapElemento.descripcion = :mapElemento");

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
            builder.append(" u.fechaAlta = :fechaAlta");

        }


        Query query = entityManager.createQuery(builder.toString());
        if(Objects.nonNull(request.getAudEmpresa()) && !request.getAudEmpresa().trim().isEmpty()){
            query.setParameter("audEmpresa", request.getAudEmpresa());
        }
        if(Objects.nonNull(request.getMapElemento()) && !request.getMapElemento().trim().isEmpty()){
            query.setParameter("mapElemento", request.getMapElemento());
        }
        if(Objects.nonNull(request.getMapFormato()) && !request.getMapFormato().trim().isEmpty()){
            query.setParameter("mapFormato", request.getMapFormato());
        }
        if(Objects.nonNull(request.getMapMedio()) && !request.getMapMedio().trim().isEmpty()){
            query.setParameter("mapMedio", request.getMapMedio());
        }
        if(Objects.nonNull(request.getMapProvincia()) && !request.getMapProvincia().trim().isEmpty()){
            query.setParameter("mapProvincia", request.getMapProvincia());
        }
        if(Objects.nonNull(request.getAudLocalidad()) && !request.getAudLocalidad().trim().isEmpty()){
            query.setParameter("audLocalidad", request.getAudLocalidad());
        }
        if(Objects.nonNull(request.getFechaAlta())){
            query.setParameter("fechaAlta", request.getFechaAlta());
        }

        return query.getResultList();
    }


    private String where(){
        return WHERE;
    }


    private String and(){
        return AND;
    }
}
