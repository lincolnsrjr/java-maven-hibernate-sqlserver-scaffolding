package br.com.lincolnsrjr.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.lincolnsrjr.util.HibernateUtil;

public abstract class AbstractRepository<T> {
	
	protected T model;
	private Class<T> typeClass;
	protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	protected List<T> list;	
	protected Session session;
	protected Transaction transaction;
	
	public AbstractRepository(Class<T> typeClass){
		this.typeClass = typeClass;
	}
	
	protected void abrirSessao(){
		if(session == null || !session.isOpen())
			session = sessionFactory.openSession();
	}
	
	protected void fecharSessao(){
		if(session.isOpen())
			session.close();
	}
	
	protected void abrirTransacao(){
		if(session.isOpen())
			transaction = session.beginTransaction();
	}
	
	protected void fazerRollback(){
		if(session.isOpen() && transaction.isActive()){
			transaction.rollback();
			session.close();
		}			
	}
	
	protected void fazerCommit(){
		if(session.isOpen() && transaction.isActive()){
			transaction.commit();
			session.close();
		}			
	}
	
	public void inserir(T t){
		try{
			abrirSessao();
			abrirTransacao();
			session.save(t);
			fazerCommit();
		}catch(Exception e){
			e.printStackTrace();
			fazerRollback();
		}		
		fecharSessao();
	}
	
	public void inserir(List<T> ts){
		try{
			abrirSessao();
			abrirTransacao();
			for(T t : ts)
				session.save(t);
			fazerCommit();
		}catch(Exception e){
			e.printStackTrace();
			fazerRollback();
		}		
		fecharSessao();
	}
	
	public void atualizar(T t){
		try{
			abrirSessao();
			abrirTransacao();
			session.merge(t);
			fazerCommit();
		}catch(Exception e){
			e.printStackTrace();
			fazerRollback();
		}		
		fecharSessao();
	}
	
	public void atualizar(List<T> ts){
		try{
			abrirSessao();
			abrirTransacao();
			for(T t : ts)
				session.merge(t);
			fazerCommit();
		}catch(Exception e){
			e.printStackTrace();
			fazerRollback();
		}		
		fecharSessao();
	}
	
	public void deletar(T t){
		try{
			abrirSessao();
			abrirTransacao();
			session.delete(t);
			fazerCommit();
		}catch(Exception e){
			e.printStackTrace();
			fazerRollback();
		}		
		fecharSessao();
	}
	
	public void deletar(List<T> ts){
		try{
			abrirSessao();
			abrirTransacao();
			for(T t : ts)
				session.delete(t);		
			fazerCommit();
		}catch(Exception e){
			e.printStackTrace();
			fazerRollback();
		}		
		fecharSessao();
	}
	
	protected List<T> selecionar(StringBuilder sb){
		list = null;
		abrirSessao();
		try{
			list = this.session.createNativeQuery(sb.toString(), typeClass).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		fecharSessao();
		return list;
	}
}
