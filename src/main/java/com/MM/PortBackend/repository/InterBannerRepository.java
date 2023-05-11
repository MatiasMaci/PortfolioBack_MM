/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MM.PortBackend.repository;

import com.MM.PortBackend.model.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterBannerRepository extends JpaRepository<Banner, Integer>{
    public Optional<Banner> findByImagen(String imagen);
    public boolean existsByImagen(String imagen);
}
