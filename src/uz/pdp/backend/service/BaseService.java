package uz.pdp.backend.service;

import uz.pdp.backend.entity.BaseModel;

import java.util.List;

public interface BaseService<E extends BaseModel>{
   boolean create(E entity);
   E get(String id);
   List<E> getList();
   boolean  update(E newEntity);
   boolean delete(String id);

}
