/*
 * Time.java
 * 
 * Copyright 2019 Robson Araújo Lima <robson@robson-lenovo>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
//package br.com.codenation;

import java.time.LocalDate;

public class Time {
	private Long id;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	
	public void setId(Long id) {
		this.id = id;
    }
	public Long getId() {
		return id;
    }
      
    public void setNome(String nome) {
        this.nome = nome;
    }    
    public String getNome() {
        return nome;
    }
    
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }    
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    
    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }    
    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }
    
    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }    
    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }
}

