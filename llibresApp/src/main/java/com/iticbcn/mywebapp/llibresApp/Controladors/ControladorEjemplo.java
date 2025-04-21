package com.iticbcn.mywebapp.llibresApp.Controladors;


//import com.iticbcn.mywebapp.llibresApp.Serveis.ProductService;
 /*
@RestController
@RequestMapping("/api/llibreria")
public class RESTBookController {
 
    @Autowired
    private ProductService llibreService; 
 
    @GetMapping("/")
    public String iniciar() {
        return "API BIBLIOTECA";
    }
 
    @GetMapping("/consulta") 
    public Set<LlibreDTO> consulta() {
 
        Set<LlibreDTO> llibreDTOs = llibreService.findAll();
 
        return llibreDTOs;
    }
 
    @PostMapping("/inserir")
    public String inserir(@RequestBody LlibreDTO llibreDTO) {
 
        llibreService.save(llibreDTO);    
 
        return "llibre inserit amb èxit";  
    }
 
    @GetMapping("/cercaid")
    public ResponseEntity<?> cercaId(@RequestParam String idLlibre) {
 
        try {
            Long idLl = Long.parseLong(idLlibre);
 
            Optional<LlibreDTO> llibreDTO = llibreService.findByIdLlibre(idLl);
 
                 return llibreDTO
                        .map(llibre -> ResponseEntity.ok(llibre.toString()))
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No hi ha cap llibre amb aquesta id"));
 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ID no vàlid: ha de ser un número.");
        } 
 
    }
 
}
    */
 