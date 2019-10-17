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


        if(Objects.nonNull(request.getAudEmpresa()) && !request.getAudEmpresa().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.audEmpresa.descripcion = :audEmpresa");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapElemento()) && !request.getMapElemento().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapElemento.descripcion = :mapElemento");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapFormato()) && !request.getMapFormato().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapFormato.descripcion = :mapFormato");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapMedio()) && !request.getMapMedio().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append("u.mapMedio.descripcion = :mapMedio");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getMapProvincia()) && !request.getMapProvincia().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.mapProvincia.descripcion = :mapProvincia");

            isFirstClause = false;
        }
        if(Objects.nonNull(request.getAudLocalidad()) && !request.getAudLocalidad().isEmpty()){
            builder.append(isFirstClause ? where() : and());
            builder.append(" u.audLocalidad.descripcion = :audLocalidad");

        }


        Query query = entityManager.createQuery(builder.toString());
        if(Objects.nonNull(request.getAudEmpresa()) && !request.getAudEmpresa().isEmpty()){
            query.setParameter("audEmpresa", request.getAudEmpresa());
        }
        if(Objects.nonNull(request.getMapElemento()) && !request.getMapElemento().isEmpty()){
            query.setParameter("mapElemento", request.getMapElemento());
        }
        if(Objects.nonNull(request.getMapFormato()) && !request.getMapFormato().isEmpty()){
            query.setParameter("mapFormato", request.getMapFormato());
        }
        if(Objects.nonNull(request.getMapMedio()) && !request.getMapMedio().isEmpty()){
            query.setParameter("mapMedio", request.getMapMedio());
        }
        if(Objects.nonNull(request.getMapProvincia()) && !request.getMapProvincia().isEmpty()){
            query.setParameter("mapProvincia", request.getMapProvincia());
        }
        if(Objects.nonNull(request.getAudLocalidad()) && !request.getAudLocalidad().isEmpty()){
            query.setParameter("audLocalidad", request.getAudLocalidad());
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
