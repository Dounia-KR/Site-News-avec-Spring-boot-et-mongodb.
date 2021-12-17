package com.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.app.models.Amis;
import com.app.models.Comment;
import com.app.models.News;
import com.app.models.Score;
import com.app.models.User;
import com.app.repositories.AmisRepository;
import com.app.repositories.CommentRepository;
import com.app.repositories.NewsRepository;
import com.app.repositories.NewsRepositoryCustom;
import com.app.repositories.ScoreRepository;
import com.mongodb.client.result.UpdateResult;

@Repository
public class ServiceNews implements NewsRepositoryCustom{
	    @Autowired
	    private MongoTemplate mongoTemplate;
	     @Autowired
	     private NewsRepository repository;
	    @Autowired
	    private CommentRepository repositorycomment;
	    @Autowired
	    private  AmisRepository amisrep;
	    @Autowired
	    private ScoreRepository scorerep;
	    
	   @Override
	    public long updateNews(String URL) {
		   
		   News news= repository.findByURL(URL);
		   ArrayList<Comment> comments = new ArrayList<Comment>();
		   comments=repositorycomment.findByURL(URL);
		   ArrayList<Comment> listecom= new ArrayList<Comment>();
		   for(Comment c : comments) {
			   Comment comment = new Comment(c.getComment(),c.getDate(),c.getUser());
			   listecom.add(comment);
		   }
		   
		 Query query = new Query(Criteria.where("URL").is(URL));
		
	        Update update = new Update();
	       
	        update.set("comment", listecom);
	     
	        UpdateResult result = this.mongoTemplate.updateFirst(query, update, News.class);
	       
	        if (result != null) {
	        	
	            return result.getModifiedCount();
	        }
            
	        return 0;
	    }
	   public ArrayList<News> newsAmis(String login){
		   
		  ArrayList<News> news=(ArrayList) repository.findAll();
		 
		  ArrayList<News> listeNews =new ArrayList<>();
		 
		  if(amisrep.existsByMoi(login)) {
			  
			  Amis amis= amisrep.findByMoi(login);
			
			   ArrayList<String> a = new ArrayList<String>();
			   
			   a=amis.getAmis();
			   
			   for( News n : news) {
				   User user=n.getUser();
				   String l=user.getLogin();
				 
				   for(String ami :a) {
				
					   if(l.equals(ami)) {
						   
						   listeNews.add(n);
					
					   }
				   }
			   }
		  }
	
		   return listeNews;
	   }


  public void updatescore(String idNews,int num) {
	 
	  News news= repository.findById(idNews).orElse(null);
	  
	  List<Score> scores = scorerep.findAll();
	
	  for(Score s : scores) {
		  
		  if((s.getId()).equals(news.getId())) {
			 
			  news.setScoreTotal(s.getValue());
		      break;
		  }
	  }
	  if(num==1) {
		  news.setScoreamie(news.getScoreamie()+1);
	  }else {
		  news.setScoredeteste(news.getScoredeteste()-1);
	  }
	       
	 
	  repository.save(news);
  }

  
  }
  
  
  