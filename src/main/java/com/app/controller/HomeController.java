package com.app.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.*;


import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.models.Amis;
import com.app.models.Comment;
import com.app.models.News;
import com.app.models.Reaction;
import com.app.models.Score;
import com.app.models.User;
import com.app.repositories.AmisRepository;
import com.app.repositories.CommentRepository;
import com.app.repositories.NewsRepository;
import com.app.repositories.ReactionRepository;
import com.app.repositories.ScoreRepository;
import com.app.repositories.UserRepository;
import com.app.service.ServiceAmis;
import com.app.service.ServiceNews;
import com.app.service.ServiceReaction;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;




@Controller
public class HomeController {
	@Autowired
	private UserRepository userrep;
	@Autowired
	private NewsRepository newsrep;
	@Autowired
	private CommentRepository commentrep;
	@Autowired
	private ServiceNews service;
	@Autowired
	private ReactionRepository reactionrep;
	@Autowired
	private ServiceReaction servicereaction;
	@Autowired
	private AmisRepository amisrep;
	@Autowired
	private ServiceAmis serviceamis;
	@Autowired
	private ScoreRepository scorerep;
	
	@GetMapping("/")
	public String signin(@ModelAttribute("user") User u,Model model) {

		return "login";
	}
	
	 @GetMapping("/register") 
	 public String signup(@ModelAttribute("user") User u)
	 { return "register"; }
	 
	 
	 
	 @PostMapping("/save")
	 public String save(@ModelAttribute User u,Model model,@ModelAttribute News news,@ModelAttribute Comment comment) {
		
		 
    	 model.addAttribute("newsAll",this.newsrep.findByLogin(u.getLogin()));
    	 
    	  String messagevide="champs obligatoire";
    	 
    	  String loginexsite="login deja existe";
    	  if(!(u.getNom().equals("")) && !(u.getPrenom().equals("")) && !(u.getLogin().equals("")) && !(u.getPassword().equals("")) && !(u.getRe_pass().equals(""))) {
    	  
		    if(u.getRe_pass().equals(u.getPassword()) && userrep.existsByLogin(u.getLogin())==false) {
	          u=new User(u.getNom(),u.getPrenom(),u.getLogin(),u.getPassword());
		      userrep.insert(u);
		     
		      model.addAttribute("login",u.getLogin());
		     
		      
		      model.addAttribute("users", this.serviceamis.amis(u.getLogin()));
		     
		      model.addAttribute("newsaime", this.servicereaction.newsaime(u.getLogin()));
		      System.out.println("saving");
		      return "profil1";
		    }else {
			  System.out.println("No save");
			  model.addAttribute("loginexiste",loginexsite);
			  return "register";
		    }
		 }else {
			 if((u.getNom().equals(""))) {
				 model.addAttribute("messagevide1", messagevide);
				
			 }
			 if((u.getPrenom().equals(""))) {
				 model.addAttribute("messagevide2", messagevide);
			 }
			 if((u.getLogin().equals(""))){
				 model.addAttribute("messagevide3", messagevide);
			 }
			 
			 if((u.getPassword().equals(""))) {
				 model.addAttribute("messagevide4", messagevide);
			 }
			 if((u.getRe_pass().equals(""))){
				 model.addAttribute("messagevide5", messagevide);
			 }
			return "register"; 
		 } 
    	  
	}
	 
	 @GetMapping("/profil1/{login}")
	 public String profil(@PathVariable("login") String login,@ModelAttribute User u,Model model,@ModelAttribute News news,@ModelAttribute Comment comment) {
		 User user= userrep.findBylogin(login);
		 model.addAttribute("login",login);
		 model.addAttribute("users", this.serviceamis.amis(u.getLogin()));
		 model.addAttribute("newsAll",this.newsrep.findByLogin(u.getLogin()));
		 model.addAttribute("newsaime", this.servicereaction.newsaime(u.getLogin()));
		 model.addAttribute("user", user);
		 
		 return "profil1";
	 }
		
     @PostMapping("/find") 
     public String  find(@ModelAttribute User u,BindingResult result,Model model,@ModelAttribute News news,@ModelAttribute Comment comment) {
    	  
    	
    	 
    	  String loginvide="login ne doit pas etre vide";
    	  String passwordvide="mot de passe ne doit pas etre vide";
		  if(((u.getLogin()).equals(""))&&((u.getPassword()).equals(""))) {
			  System.out.println("null");
			  model.addAttribute("loginvide",loginvide);
			  model.addAttribute("passwordvide",passwordvide);
			  return "login";
		  }else  if(((u.getLogin()).equals(""))) {
			  System.out.println("null login ");
			  model.addAttribute("loginvide",loginvide);
			  return "login";
		  }else  if(((u.getPassword()).equals(""))) {
			  System.out.println("null password");
			  model.addAttribute("passwordvide",passwordvide);
			  return "login";
		  }
		
          else  {
        	      model.addAttribute("login",u.getLogin());
        		 model.addAttribute("users", this.serviceamis.amis(u.getLogin()));
        		
        		model.addAttribute("newsAll",this.newsrep.findByLogin(u.getLogin()));
        		 model.addAttribute("newsaime", this.servicereaction.newsaime(u.getLogin()));
            String message="login incorrect";	
    	     System.out.println("no null"); 
    		 List<User> users = userrep.findAll(); 
    	     System.out.println("dounia");
    	     System.out.println(u);
    		 for(User user : users) {
    		    System.out.println("message");
    			if((user.getLogin().equals(u.getLogin()))){
    			    System.out.println("login : "+u.getLogin()+"password "+u.getPassword()+"user"+ user.getNom());
    			    message="login correct";
    			    if((user.getPassword().equals(u.getPassword()))) {
    			
    			         model.addAttribute("user", u);
    			    	 return "profil1";
    			    }
    			   
		        }
		 
		     }
    		 if(message.equals("login correct")) {
    		message="mot de passe incorrect";	 
    		 model.addAttribute("erreurpassword",message);
    		 return "login";
    		 }else {
    			 message="login incorrect";	 
        		 model.addAttribute("erreurlogin",message);
        		 return "login";
    		 }
            }
     
     }
     
     @PostMapping("/savenews/{login}")
     public String savenews(@ModelAttribute News news,Model model,@PathVariable("login") String login,@ModelAttribute User u,@ModelAttribute Comment comment) {
    	 
    	 User user=userrep.findBylogin(login);
    	
    	
    	 if(newsrep.existsByURL(news.getURL())) {
    		
    		 
    		 model.addAttribute("message", "Url deja existe");
    		 model.addAttribute("user", this.userrep.findBylogin(login));
    		 model.addAttribute("news", news);
        	 model.addAttribute("users", this.serviceamis.amis(login));
        	 model.addAttribute("newsAll",this.newsrep.findByLogin(login));
        	 model.addAttribute("newsaime", this.servicereaction.newsaime(login));
    		 return "profil1";
    	 }
    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
    	 
    	 news = new News(news.getURL(),dtf.format(now),news.getTitre(),new User(login));
    	 newsrep.insert(news);
    	 model.addAttribute("user", user);
    	
    	 model.addAttribute("news", news);
    	 model.addAttribute("users", this.serviceamis.amis(login));
    	 model.addAttribute("newsAll",this.newsrep.findByLogin(login));
    	 model.addAttribute("newsaime", this.servicereaction.newsaime(login));
    	 model.addAttribute("message", "Url partager");
    	 
    	 model.addAttribute("news",new News());
    	 return "profil1";
    	 
     }     
        @PostMapping("/savecomment/{id}/{login}/{vue}")
        public String comment(@PathVariable("id") String id,@PathVariable("login") String login,@PathVariable("vue") String vue,@ModelAttribute Comment comment,@ModelAttribute User u,@ModelAttribute News news,Model model ) {

        	User user = new User(login);
        	 //model.addAttribute("user", user);
        	
        	 model.addAttribute("login",login);
       		 model.addAttribute("news", news);
        	 model.addAttribute("users", this.serviceamis.amis(login));
        	 model.addAttribute("newsAll",this.newsrep.findByLogin(login));
        	 model.addAttribute("newsaime", this.servicereaction.newsaime(login));
        	 ArrayList<News> listeNews = service.newsAmis(login);
             model.addAttribute("newsAmis",listeNews);
             News nn=newsrep.findById(id).orElse(null);
  		     model.addAttribute("n", nn);
  		     model.addAttribute("user", nn.getUser().getLogin());
  		     model.addAttribute("loginaime",this.servicereaction.loginAime(id));
  		     model.addAttribute("logindeteste",this.servicereaction.logindeteste(id));
        	
        	if(comment.getComment().equals("")) {
        		 model.addAttribute("comments", this.commentrep.findByURL(nn.getURL()));
        		 
            	return vue;
            }
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 
 
            Comment com= new Comment(comment.getComment(),dtf.format(now),user,nn);
            commentrep.insert(com);
            service.updateNews(nn.getURL());
            model.addAttribute("comments", this.commentrep.findByURL(nn.getURL()));
            model.addAttribute("comment",new Comment()); 
        	return vue;
        }
        @GetMapping("/savereaction/{num}/{id}/{login}/{vue}")
        public String reaction(@PathVariable("num") int num ,@PathVariable("id") String id,@PathVariable("login") String login,@PathVariable("vue") String vue,@ModelAttribute Comment comment,@ModelAttribute User u,@ModelAttribute News news,Model model) {
            
        	
        	
        	if(servicereaction.verficationReaction(login, id)) {
            	   User user = new User(login);
            	  
             	  model.addAttribute("news", news);
             	  model.addAttribute("users", this.serviceamis.amis(login));
             	  model.addAttribute("newsaime", this.servicereaction.newsaime(login));
                  model.addAttribute("newsAll",this.newsrep.findByLogin(login));
                  model.addAttribute("newsAmis",this.service.newsAmis(login));
                  News n=newsrep.findById(id).orElse(null);
       		      model.addAttribute("n", n);
       		      model.addAttribute("comments", this.commentrep.findByURL(n.getURL()));
       		      //model.addAttribute("login",login);
       		      model.addAttribute("loginaime",this.servicereaction.loginAime(id));
       		      model.addAttribute("logindeteste",this.servicereaction.logindeteste(id));
       		      model.addAttribute("user", n.getUser().getLogin());
                  
            	return vue;
            }
             	Reaction reaction =new Reaction(id,login,num);
             
                  reactionrep.insert(reaction);
             	  servicereaction.fonction();
             	  service.updatescore(id,num);
                  servicereaction.newsaime(login);
                  User user = new User(login);
                  //model.addAttribute("user", user);
             	  model.addAttribute("news", news);
             	  model.addAttribute("users", this.serviceamis.amis(login));
                  model.addAttribute("newsaime", this.servicereaction.newsaime(login));
                  model.addAttribute("newsAll",this.newsrep.findByLogin(login));
                  model.addAttribute("newsAmis",this.service.newsAmis(login));
                  News n=newsrep.findById(id).orElse(null);
       		      model.addAttribute("n", n);
       		      model.addAttribute("comments", this.commentrep.findByURL(n.getURL()));
       		     // model.addAttribute("login",login);
       		      model.addAttribute("loginaime",this.servicereaction.loginAime(id));
       		      model.addAttribute("logindeteste",this.servicereaction.logindeteste(id));
       		      model.addAttribute("user", n.getUser().getLogin());
        return vue;
        }
        @GetMapping("/amis/{login}")
        public String amis(@PathVariable("login") String login,@ModelAttribute User u,Model model) {
        	
        	model.addAttribute("login", login);
        	ArrayList<User> liste=new ArrayList<>();
        	liste=serviceamis.nonamis(login);
        	model.addAttribute("users", liste);
        	
        	return "amis";
        }
     
        
        @GetMapping("/addamis/{ami}/{login}")
        public String addamis(@PathVariable("ami") String ami,@PathVariable("login") String moi,@ModelAttribute User u,Model model) {
        	
        
        	
        	if(!(amisrep.existsByMoi(moi))) {
        		
        		ArrayList<String> listamis= new ArrayList<>();
        		
        		listamis.add(ami);
        		
        		Amis amis =new Amis(moi,listamis);
        		
        		amisrep.insert(amis);
        		
        		model.addAttribute("users", this.serviceamis.nonamis(moi));
        		
        		return "amis";
        	}
        
        	serviceamis.updateAmis(moi, ami);
        	
        	model.addAttribute("users", this.serviceamis.nonamis(moi));
        	return "amis";
        }
        @GetMapping("/newsAmis/{login}")
        public String newsAmis(@PathVariable("login") String login,@ModelAttribute Comment comment,@ModelAttribute User u,Model model,@ModelAttribute News news ) {
        	ArrayList<News> listeNews = service.newsAmis(login);
        	model.addAttribute("login", login);
        	model.addAttribute("newsAmis",listeNews);
        	return "newsAmis";
        }
        
        @GetMapping("/news/{id}/{login}")
        public String AffichageNews(@PathVariable("id") String id,@PathVariable("login") String login,@ModelAttribute Comment comment,@ModelAttribute User u,Model model,@ModelAttribute News news) {
           News n=newsrep.findById(id).orElse(null);
           
		   model.addAttribute("n", n);
		   model.addAttribute("comments", this.commentrep.findByURL(n.getURL()));
		   model.addAttribute("login",login);
		   model.addAttribute("loginaime",this.servicereaction.loginAime(id));
		   model.addAttribute("logindeteste",this.servicereaction.logindeteste(id));
        	return "news";	
        }
        
        @GetMapping("/profilamis/{ami}/{login}")

        public String profilamis(@PathVariable("ami") String ami,@PathVariable("login") String login,@ModelAttribute Comment comment,@ModelAttribute User u,Model model,@ModelAttribute News news) {
        	ArrayList<News> n = new ArrayList<News>();
        	n=(ArrayList)newsrep.findByLogin(ami);
        	model.addAttribute("newsAll",n);
        	model.addAttribute("login", login);
        	model.addAttribute("user", ami);
        	return "profilamis";
        }
        
  
}
