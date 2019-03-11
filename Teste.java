//package br.com.codenation;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
//import System.Collections.Generic;


//import br.com.codenation.desafio.annotation.Desafio;
//import br.com.codenation.desafio.app.MeuTimeInterface;

//public class DesafioMeuTimeApplication implements MeuTimeInterface {
public class Teste {
	
	List<Time> listaTime = new ArrayList<>();
	List<Jogador> listaJogador = new ArrayList<>();
	Map<Long, Long> capitaoDoTime = new HashMap<>();
	//@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		for (Time c: listaTime)
		{
			if (c.getId().equals(id))
			{
				throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException");
			}
		}
		Time novoTime = new Time();
		novoTime.setId(id);
		novoTime.setNome(nome);
		novoTime.setDataCriacao(dataCriacao);
		novoTime.setCorUniformePrincipal(corUniformePrincipal);
		novoTime.setCorUniformeSecundario(corUniformeSecundario);
		listaTime.add(novoTime);
		//for (Time c: listaTime)
		//{
			//System.out.println(c.getId() + " " + c.getNome() + " " + c.getDataCriacao());
		//}
	}

	//@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		for (Jogador c: listaJogador)
		{
			if (c.getId().equals(id))
			{
				throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException");
			}
		}
		
		boolean existe = false;
		for (Time c: listaTime)
		{
			if (c.getId().equals(idTime))
			{
				existe = true;
				break;
			}
		}
		if (existe)
		{
			Jogador novoJogador = new Jogador();
			novoJogador.setId(id);
			novoJogador.setIdTime(idTime);
			novoJogador.setNome(nome);
			novoJogador.setDataNascimento(dataNascimento);
			novoJogador.setNivelHabilidade(nivelHabilidade);
			novoJogador.setSalario(salario);
			listaJogador.add(novoJogador);
			//for (Jogador c: listaJogador)
			//{
				//System.out.println(c.getId() + " " + c.getNome() + " " + c.getDataNascimento() + " " + c.getSalario());
			//}
		} else 
		{
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}
	}

	//@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		boolean existe = false;
		for (Jogador c: listaJogador)
		{
			if (c.getId().equals(idJogador))
			{
				capitaoDoTime.put(c.getIdTime(),c.getId());
				existe = true;
				break;
			}
		}
		if (existe == false)
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException");
		//for (Map.Entry<Long, Long> entry : capitaoDoTime.entrySet())
		//{
			//System.out.println(entry.getKey() + " : " + entry.getValue());
		//}
	}

	//@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		boolean existe = false;
		for (Time c: listaTime)
		{
			if (c.getId().equals(idTime))
			existe = true;
		}
		if (existe)
		{
			if (capitaoDoTime.containsKey(idTime))
			{
				return capitaoDoTime.get(idTime);
			}
			else
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException");
		}
		else
		{
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}
		
	}

	//@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		for (Jogador c: listaJogador)
		{
			if (c.getId().equals(idJogador))
			return c.getNome();
		}
		throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException");
	}

	//@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		for (Time c: listaTime)
		{
			if (c.getId().equals(idTime))
			return c.getNome();
		}
		throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
	}

	//@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> result = listaJogador.stream()
			.filter(x-> idTime.equals(x.getIdTime()))
			.sorted((o1, o2)-> o1.getId().compareTo(o2.getId()))
			.map(Jogador::getId)
			.collect(Collectors.toList());
        if (result.isEmpty())
        throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
        else
        return result;
		//boolean existe = false;
		//List<Long> lista = new ArrayList<>();
		//for(Jogador c: listaJogador)
		//{
			//if (c.getIdTime().equals(idTime))
			//{
				//existe = true;
				//lista.add(c.getId());
			//}
		//}
		//if (existe)
		//{
			//lista.sort((Long o1, Long o2)->o1.intValue()-o2.intValue());
			//System.out.println("Lista ordenada: " + lista.toString());
			//return lista;
		//}
		//else
		//throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
	}

	//@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		List<Long> result = listaJogador.stream()
			.filter(x-> idTime.equals(x.getIdTime()))
			.sorted((o1, o2)-> Integer.compare(o2.getNivelHabilidade(), o1.getNivelHabilidade()))//reverse order
			.limit(1)//the biggest first element in the list
			.map(Jogador::getId)
			.collect(Collectors.toList());
        if (result.isEmpty())
        throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
        else
        {
			return result.get(0);
		}
		//boolean existe = false;
		//List<Integer> lista = new ArrayList<>();
		//for (Jogador c: listaJogador)
		//{
			//if (c.getIdTime().equals(idTime))
			//{
				//existe = true;
				//lista.add(c.getNivelHabilidade());
			//}
		//}
		//if (existe)
		//{
			////Comparator<Long> habilidade = (o1, o2)->o1.intValue().compareTo(o2.intValue());
			//Comparator<Integer> habilidade = (o1, o2)->o1.compareTo(o2);
			//lista.sort(habilidade.reversed());
			//System.out.println("lista em ordem decrescente: " + lista.toString());
			//return lista.get(0).longValue();
		//}
		//else
		//throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
	}

	//@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		List<Long> result = listaJogador.stream()
			.filter(x-> idTime.equals(x.getIdTime()))
			.sorted(Comparator.comparing((Jogador x) -> daysLived(x.getDataNascimento())).reversed()
					.thenComparing((Jogador x) -> x.getId()))
			.limit(1)//the biggest first element in the list
			.map(Jogador::getId)
			.collect(Collectors.toList());
		if (result.isEmpty())
		throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
        else
        {
			return result.get(0);
		}
	}

	//@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
	List<Long> result = new ArrayList<>();
	for (Time c: listaTime)
	{
		result.add(c.getId());
	}
	Collections.sort(result);
	return result;
}

	//@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		List<Long> result = listaJogador.stream()
			.filter(x-> idTime.equals(x.getIdTime()))
			.sorted(Comparator.comparing(Jogador::getSalario).reversed()
					.thenComparing(Jogador::getId))
			.limit(1)//the biggest first element in the list
			.map(Jogador::getId)
			.collect(Collectors.toList());
		if (result.isEmpty())
		throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
        else
        {
			System.out.println(result.get(0));
			return result.get(0);
		}
	}

	//@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		boolean existe = false;
		BigDecimal result = new BigDecimal("0");
		for (Jogador c: listaJogador)
		{
			if (c.getId().equals(idJogador))
			{
				existe = true;
				result = c.getSalario();
			}
		}
		if (existe)
		return result;
		else
		throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException");
	}

	//@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> result = listaJogador.stream()
			.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()
					.thenComparing(Jogador::getId))
			.limit(top.intValue())//the biggest firsts elements in the list
			.map(Jogador::getId)
			.collect(Collectors.toList());
		return result;
	}

	//@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeCasa = new Time();
		Time timeFora = new Time();
		boolean existeFora = false;
		boolean existeCasa = false;
		for(Time c: listaTime)
		{
			if (c.getId().equals(timeDaCasa))
			{
				existeCasa = true;
				timeCasa = c;
			}
			else if (c.getId().equals(timeDeFora))
			{
				existeFora = true;
				timeFora = c;
			}
		}
		
		if (existeCasa && existeFora)
		{
			if (timeFora.getCorUniformePrincipal().equals(timeCasa.getCorUniformePrincipal()))
			return timeFora.getCorUniformeSecundario();
			else if (!timeFora.getCorUniformePrincipal().equals(timeCasa.getCorUniformePrincipal()))
			return timeFora.getCorUniformePrincipal();
		}
		else
		{
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}
		return "";
	}

	
	public long daysLived(LocalDate date)
	{
		LocalDate todayDate = LocalDate.now();
		long days = ChronoUnit.DAYS.between(date, todayDate);
		return days;
	}
	
	public int compareTo0(LocalDate otherDate) {
	LocalDate localDate = LocalDate.now();
		int cmp = (localDate.getYear() - otherDate.getYear());
		if (cmp == 0) {
			cmp = (localDate.getMonthValue() - otherDate.getMonthValue());
			if (cmp == 0) {
				cmp = (localDate.getDayOfMonth() - otherDate.getDayOfMonth());
			}
		}
	return cmp;
}
	
	public static void main (String[] args) {
		Teste i = new Teste();

		i.incluirTime(new Long("2"),"flamengo",LocalDate.now(),"vermelho","preto");
		i.incluirTime(new Long("4"),"corintias",LocalDate.now(),"amarelo","branco");
		i.incluirTime(new Long("6"),"a",LocalDate.now(),"amarelo","branco");
		i.incluirTime(new Long("8"),"b",LocalDate.now(),"amarelo","branco");
		i.incluirTime(new Long("10"),"c",LocalDate.now(),"amarelo","branco");
		
		//i.incluirJogador(new Long("1"),new Long("2"), "Robson", LocalDate.of(1995, Month.JANUARY, 15), new Integer("10"), new BigDecimal("100.26"));
		//i.incluirJogador(new Long("3"),new Long("2"), "Ashey", LocalDate.of(1994, Month.APRIL, 6), new Integer("24"), new BigDecimal("100.25"));
		//i.incluirJogador(new Long("5"),new Long("2"), "Adriel", LocalDate.of(1994, Month.APRIL, 6), new Integer("24"), new BigDecimal("100.25"));
		//i.incluirJogador(new Long("7"),new Long("2"), "a", LocalDate.of(1994, Month.APRIL, 6), new Integer("12"), new BigDecimal("100.25"));
		//i.incluirJogador(new Long("9"),new Long("2"), "b", LocalDate.of(1994, Month.APRIL, 6), new Integer("13"), new BigDecimal("100.25"));
		
		//i.definirCapitao(new Long("1"));
		//i.definirCapitao(new Long("3"));
		//i.definirCapitao(new Long("5"));
		//i.definirCapitao(new Long("7"));
		//i.definirCapitao(new Long("9"));
		//i.definirCapitao(new Long("9"));
		//System.out.println(i.buscarCapitaoDoTime(new Long("1")));
		
		//System.out.println(i.buscarNomeJogador(new Long("1")));
		//System.out.println(i.buscarNomeJogador(new Long("3")));
		//System.out.println(i.buscarNomeJogador(new Long("5")));
		//System.out.println(i.buscarNomeJogador(new Long("7")));
		//System.out.println(i.buscarNomeJogador(new Long("9")));
		
		//System.out.println(i.buscarNomeTime(new Long("2")));
		//System.out.println(i.buscarNomeTime(new Long("4")));
		//System.out.println(i.buscarNomeTime(new Long("6")));
		//System.out.println(i.buscarNomeTime(new Long("8")));
		//System.out.println(i.buscarNomeTime(new Long("10")));
		
		//System.out.println(i.buscarJogadoresDoTime(new Long("2")).toString());
		//System.out.println(i.buscarJogadoresDoTime(new Long("4")).toString());
		//System.out.println(i.buscarJogadoresDoTime(new Long("6")).toString());
		//System.out.println(i.buscarJogadoresDoTime(new Long("8")).toString());
		//System.out.println(i.buscarJogadoresDoTime(new Long("10")).toString());
		
		//System.out.println(i.buscarMelhorJogadorDoTime(new Long("4")));
		
		//System.out.println(i.buscarJogadorMaisVelho(new Long("2")));
		System.out.println(i.buscarTimes());
		//i.buscarJogadorMaiorSalario(new Long("1"));
		//System.out.println(i.buscarSalarioDoJogador(new Long("368")));
		//System.out.println(i.buscarTopJogadores(new Integer("10")));
		//System.out.println(i.buscarCorCamisaTimeDeFora(new Long("2"), new Long("4")));
		//System.out.println(i.daysLived(LocalDate.of(2019, Month.MARCH, 9)));
	}

}
