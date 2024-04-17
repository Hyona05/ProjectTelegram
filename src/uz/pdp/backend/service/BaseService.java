package uz.pdp.backend.service;

import uz.pdp.backend.entity.BaseModel;

import java.util.List;

public interface BaseService<E extends BaseModel>{
   void create(E entity);
   E get(String id);
   List<E> getList();
   void update(E newEntity);
   void delete(String id);

}
