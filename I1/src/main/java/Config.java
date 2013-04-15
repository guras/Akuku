import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import pl.guras.i1.entity.Project;

@WebListener
public class Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("projects", Project.values());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
    }

}

