package cv.hernani.bloodbankprojectspring.controllers;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/bloodcollection")
public class StockController {

    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createStock(@Valid @RequestBody StockDto stockDto) {
        APIResponse response = stockService.createStock(stockDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllStock(){
        APIResponse response = stockService.getAllStock();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStocktById(@PathVariable(value = "id") UUID id) {
        APIResponse response = stockService.getStocktById(id);
        return new ResponseEntity.status(HttpStatus.OK).body(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStock(@PathVariable(value = "id") UUID id){
        APIResponse response = stockService.deleteStockById(id);
        return new ResponseEntity.status(HttpStatus.OK).body(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStock(@PathVariable(value = "id") UUID id,@RequestBody @Valid StockDto stockDto){        
        APIResponse response = stockService.updateStock(id);
        return new ResponseEntity.status(HttpStatus.OK).body(response, HttpStatus.OK);
    }
                                              
    }


}