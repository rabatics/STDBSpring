package spring.test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
//@RequestMapping(value = "/helloWeb")
public class StudentController {

   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "command", new Student());
   }
   
   
   
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String stud() {
      return "redirect:/student";
   }
   
   
   
   
   @RequestMapping(value = "/college", method = RequestMethod.GET)
   public String college(Model model) {
	      SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(College.class)
					.buildSessionFactory();
	     try{ 
	      Session session=factory.getCurrentSession();
	      session.beginTransaction();
	      College col=new College();
	     List<College> lstStud= session.createQuery("from College").getResultList();
	     
	     model.addAttribute("collList", lstStud);
	     model.addAttribute("command", col);
	     System.out.println("populated student list");
	      session.getTransaction().commit();
	     }
	     
	      
	     catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    	 factory.close();
	     }
	   
	   
      return "college";
   }
   
   
   
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute("SpringWeb")Student student, 
   ModelMap model) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      Method meth;
	try {
		meth = Student.class.getDeclaredMethod("print", null);
		 meth.setAccessible(true);
		 meth.invoke(student);
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
      SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
     try{ 
      Session session=factory.getCurrentSession();
      session.beginTransaction();
      session.save(student);
      session.getTransaction().commit();
     }finally{
    	 factory.close();
     }
      return "result";
   }
   
   
   
   @RequestMapping(value = "/addCollege", method = RequestMethod.POST)
   public String addCollege(@ModelAttribute("command")College college, 
   ModelMap model) {
     
     
      SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(College.class)
				.buildSessionFactory();
     try{ 
      Session session=factory.getCurrentSession();
      session.beginTransaction();
      session.save(college);
      session.getTransaction().commit();
     }finally{
    	 factory.close();
     }
      return "redirect:/FirstSpringMVC/college";
   }
   
   
   
   
   
   @RequestMapping(value = "/list", method = RequestMethod.GET)
   public String listStudents(
   ModelMap model) {
     System.out.println("in /list");
      SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
     try{ 
      Session session=factory.getCurrentSession();
      session.beginTransaction();
     List<Student> lstStud= session.createQuery("from Student").getResultList();
     
     model.addAttribute("userList", lstStud);
     System.out.println("populated student list");
      session.getTransaction().commit();
     }
     
      
     catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
    	 factory.close();
     }
      return "list";
   }
   
   
   
   
}