package com.Agrovest.repository;

import com.Agrovest.domain.Asesoria;
import org.springframework.data.repository.CrudRepository;

public interface AsesoriaRepository extends CrudRepository<Asesoria, String> {

    public void delete(Asesoria asesoria);

}
