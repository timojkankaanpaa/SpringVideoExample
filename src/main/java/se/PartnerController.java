package se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerController {
	@Autowired
	private PartnerRepository repository;
    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    }
    
    @RequestMapping("/partners")
    public Iterable<Partner> partners(@RequestParam(value="name", defaultValue="World") String name) {
        return repository.findAll();
    }    

    @RequestMapping("/partner/{id}")
    public Partner get(@PathVariable("id") int id) {
        return repository.findOne(id);
    }    

    @RequestMapping(value = "/partner" , method = RequestMethod.PUT)
    public @ResponseBody Partner update(@RequestBody Partner item) {
    	return repository.save(item);
    } 
    
    @RequestMapping(value = "/partner" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Partner item) {
    	repository.delete(item);
        //do business logic
    }     

    @RequestMapping(value = "/partner" , method = RequestMethod.POST)
    public @ResponseBody Partner create(@RequestBody Partner item) {
    	return repository.save(item);
    }  
}
