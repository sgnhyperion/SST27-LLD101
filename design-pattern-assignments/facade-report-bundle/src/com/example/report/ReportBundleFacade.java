import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private JsonWriter jw = new JsonWriter(); 
    private Zipper z = new Zipper(); 
    private AuditLog log = new AuditLog();
    
    public void export(Map<String,Object> data){
        Objects.requireNonNull(data);

        Path json = jw.write(data, Path.of("out"), "report");
        Path zip = z.zip(json, Path.of("out", "report.zip"));
        log.log("exported " + zip);
        System.out.println("DONE " + zip);
    }
}
