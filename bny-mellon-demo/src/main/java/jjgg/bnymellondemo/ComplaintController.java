package jjgg.bnymellondemo;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
    private ComplaintRepository complaintRepository;

    public ComplaintController(ComplaintRepository complaintRepository){
        this.complaintRepository=complaintRepository;
    }

    @GetMapping("/all")
    public List<Complaint> getAll(){
        List<Complaint> complaints=this.complaintRepository.findAll();
        return complaints;
    }

    @GetMapping("/allProdFor/{company}")
    public List<AngRequest> getAllByCompany(@PathVariable("company") String company){

        //create a query class (QHotel)
        QComplaint qcomplaint = new QComplaint("complaint");

        //using the query class create filters
        BooleanExpression filterByCompany = qcomplaint.company.eq(company);

        //we can then pass the filters to the findAll() method
        List<Complaint> complaints = (List<Complaint>) this.complaintRepository.findAll(filterByCompany);

        List<AngRequest> ang= new ArrayList<AngRequest>();



        for(int i=0; i<complaints.size();i++){
            String prod =complaints.get(i).getProduct();
            AngRequest angRequest= new AngRequest(prod,prod);
            ang.add(angRequest);
        }

        return ang;
    }

    @GetMapping("/allProd")
    public List<AngRequest> getAllProducts() {
        List<Complaint> complaints=this.complaintRepository.findAll();
        List<AngRequest> ang= new ArrayList<AngRequest>();

        for(int i=0; i<complaints.size();i++){
            String prod =complaints.get(i).getProduct();
            AngRequest angRequest= new AngRequest(prod,prod);
            int found =0;
            for (AngRequest hey:ang) {
                if (hey.getId().equals(prod)){
                    found++;
                    break;
                }
            }
            if(found==0){
                ang.add(angRequest);

            }
        }
        return ang;
    }

    @GetMapping("/allComp")
    public List<AngRequest> getAllCompanies() {
        List<Complaint> complaints=this.complaintRepository.findAll();
        List<AngRequest> ang= new ArrayList<AngRequest>();

        for(int i=0; i<complaints.size();i++){
            String company =complaints.get(i).getCompany();
            AngRequest angRequest= new AngRequest(company,company);
            int found =0;
            for (AngRequest hey:ang) {
                if (hey.getId().equals(company)){
                    found++;
                    break;
                }
            }
            if(found==0){
                ang.add(angRequest);
            }
        }
        return ang;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable ("id") String id){
        Complaint hotel=this.complaintRepository.getById(id);
        return hotel.getProduct();
    }

    @GetMapping("/product/{product}")
    public List<Complaint> getByProduct(@PathVariable("product") String product){
        //create a query class (QHotel)
        QComplaint qcomplaint = new QComplaint("complaint");

        //using the query class create filters
        BooleanExpression filterByProduct = qcomplaint.product.eq(product);

        //we can then pass the filters to the findAll() method
        List<Complaint> complaints = (List<Complaint>) this.complaintRepository.findAll(filterByProduct);

        return complaints;
    }

    @GetMapping("/company/{company}")
    public List<Complaint> getByCompany(@PathVariable("company") String company){
        //create a query class (QComplaint)
        QComplaint qcomplaint = new QComplaint("complaint");

        //using the query class create filters
        BooleanExpression filterByCompany = qcomplaint.company.eq(company);

        //we can then pass the filters to the findAll() method
        List<Complaint> complaints = (List<Complaint>) this.complaintRepository.findAll(filterByCompany);

        return complaints;
    }

    @GetMapping("/combo/{product}/{company}")
    public List<Complaint> getByCombo(@PathVariable("product") String product, @PathVariable("company") String company){
        //create a query class (QComplaint)
        QComplaint qcomplaint = new QComplaint("complaint");

        //using the query class create filters
        BooleanExpression filterByCompany = qcomplaint.company.eq(company);
        BooleanExpression filterByProduct = qcomplaint.product.eq(product);


        //we can then pass the filters to the findAll() method
        List<Complaint> complaints = (List<Complaint>) this.complaintRepository.findAll(filterByCompany.and(filterByProduct));

        return complaints;
    }

    @PostMapping("/update")
    public void update(@RequestBody Complaint complaint){//upsert method
        this.complaintRepository.save(complaint);
    }

    @PutMapping("/create")
    public void insert(@RequestBody Complaint complaint){//insert method
        this.complaintRepository.insert(complaint);
    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        this.complaintRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){this.complaintRepository.deleteAll();}


}
