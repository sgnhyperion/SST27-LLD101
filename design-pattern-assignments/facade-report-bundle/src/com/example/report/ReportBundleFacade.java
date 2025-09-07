import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private JsonWriter jw;
    private Zipper z;
    private AuditLog log;

    public ReportBundleFacade(){
        jw = new JsonWriter();
        z = new Zipper();
        log = new AuditLog();
    }
    
    public void export(Map<String,Object> data){
        Objects.requireNonNull(data);

        Path json = jw.write(data, Path.of("out"), "report");
        Path zip = z.zip(json, Path.of("out", "report.zip"));
        log.log("exported " + zip);
        System.out.println("DONE " + zip);
    }
}
