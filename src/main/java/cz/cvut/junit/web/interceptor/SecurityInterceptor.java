package cz.cvut.junit.web.interceptor;

import cz.cvut.junit.service.PersonService;
import cz.cvut.junit.web.controller.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jakubchalupa
 * @since 18.04.16
 */
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    protected PersonService personService;

    private static final String SECURITY_HEADER = "X-Auth";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(o instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) o;

            //from method
            CheckAccess methodAnnotation = method.getMethodAnnotation(CheckAccess.class);
            if(methodAnnotation == null) {
                //from class
                methodAnnotation = method.getBeanType().getAnnotation(CheckAccess.class);
            }

            if(methodAnnotation == null) {
                //not secured
                return true;
            }

            String securityHeader = httpServletRequest.getHeader(SECURITY_HEADER);
            if (securityHeader == null || securityHeader.length() == 0) {
                throw new UnauthorizedException();
            }

            //pole roli, ktere jsou nutne pro tento resource
            String[] rolesNeeded = methodAnnotation.value();

            //TODO z DB zjistit dle TOKENU, co je to za uzivatele a jake ma role - to bude muset byt v nove tabulce (USER_ROLES)
            //TODO nasledne staci zjistit, jestli ma alespon jednu roli z tech, co jsou v rolesNeeded
            //TODO tedy neco jako
//            Person person = personService.findPersonByToken(securityHeader);
//            for (String roleNeeded : rolesNeeded) {
//                if(person.getRoles().contains(roleNeeded)) {
//                    return true;
//                }
//            }

            //TODO smazat
            return true;

            //TODO odkomentovat
            //throw new UnauthorizedException();
        }

        throw new UnauthorizedException();
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //empty
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //empty
    }

}