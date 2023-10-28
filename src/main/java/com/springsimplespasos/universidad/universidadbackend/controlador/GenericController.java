package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class GenericController <E, S extends GenericoDAO<E>> {
    protected final S service;
    protected String nombreEntidad;
    public GenericController(S service) {
        this.service = service;
    }
    @GetMapping
    public List<E> obtenerTodos(){
        List<E> listado = (List<E>) service.findAll();
        if(listado.isEmpty()) {
            throw new BadRequestException(String.format("No se han encontrado %ss",
                    nombreEntidad));
        }
        return listado;
    }

    //obtenerPorID (Id)
    @GetMapping("{id}")
    public E obtenerPorId(@PathVariable Integer id){
        Optional<E> obj = (Optional<E>) service.findById(id);
        if(!obj.isPresent()){
            throw new BadRequestException(String.format("No se encontrado el id %ss", nombreEntidad));
        }
        return (E) obj;
    }

    //borrarEntidadPorId (Id)

    //altaEntidad (Entidad)

}
