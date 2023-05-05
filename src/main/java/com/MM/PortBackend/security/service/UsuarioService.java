/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.security.service;

import com.MM.PortBackend.security.entity.Usuario;
import com.MM.PortBackend.security.repository.InterUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    public InterUsuarioRepository IUsuarioRepo;
    
    public Optional<Usuario> getByRolNombreUsuario(String nombreUsuario){
        return IUsuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return IUsuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return IUsuarioRepo.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        IUsuarioRepo.save(usuario);
    }
    
}
