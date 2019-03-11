/*
 * Jogador.java
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
import java.math.BigDecimal;

public class Jogador {
	private Long id;
	private Long idTime;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;

	
	public void setId(Long id) {
		this.id = id;
    }
	public Long getId() {
		return id;
    }
      
    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }    
    public Long getIdTime() {
        return idTime;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }    
    public String getNome() {
        return nome;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }    
    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }
        
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }    
    public BigDecimal getSalario() {
        return salario;
    }
}

