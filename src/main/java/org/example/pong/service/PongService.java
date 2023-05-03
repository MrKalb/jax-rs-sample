package org.example.pong.service;

import org.example.pong.entity.PongEntity;
import org.example.pong.request.PongRequest;
import org.example.pong.response.PongResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PongService {



    public String returnPong(String message) {
        PongResponse pongResponse = new PongResponse();
        pongResponse.setMessage(new StringBuilder()
                .append("Receive: ")
                .append(message)
                .toString());
        return pongResponse.toString();
    }

    public void postMessage(PongRequest pongRequest) {
        PongEntity pongEntity = new PongEntity();
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("jax-rs-sample")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            pongEntity.setId(1L);
            pongEntity.setMessage(pongRequest.getMessage());
            entityManager.persist(pongEntity);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    public PongEntity getMessage() {
        PongEntity pongEntity = new PongEntity();
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("jax-rs-sample")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            pongEntity = entityManager.find(PongEntity.class, 1L);
            transaction.commit();
            return pongEntity;
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }


}
