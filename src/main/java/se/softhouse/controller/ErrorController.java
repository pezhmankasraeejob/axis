package se.softhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController extends AbstractErrorController
{

    public ErrorController(ErrorAttributes errorAttributes)
    {
        super(errorAttributes);
    }

    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> handleError(HttpServletRequest request)
    {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, true);
        return errorAttributes;
    }

    @Override
    public String getErrorPath()
    {
        return "/error";
    }
}