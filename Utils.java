public class Utils {
    // Add utility methods here
 private String defaultValues(String original) {
        if (original.contains(".") || original.isEmpty() || original.contains("\"")) {
            return "0";
        }
        return original;
    }

}