package io.github.xico26;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> awLines;
    private List<String> loaLines;
    private List<String> removedLines;
    private List<String> leftLines;

    public Controller() {
        this.awLines = new ArrayList<String>();
        this.loaLines = new ArrayList<String>();
        this.removedLines = new ArrayList<String>();
        this.leftLines = new ArrayList<String>();
    }

    public String addLine (String driverId, String discordUrl, int option) {
        // discord://-/users/ID

        String discordId = discordUrl.substring(18);

        String line = "> - " + driverId + " - <@" + discordId + ">";

        switch (option) {
            case 0:
                this.awLines.add(line);
                break;
            case 1:
                this.loaLines.add(line);
                break;
            case 2:
                this.removedLines.add(line);
                break;
            case 3:
                this.leftLines.add(line);
                break;
            default:
                System.err.println("Invalid option");
        }

        return line;
    }

    public String printAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("❌ **Didn't meet quota > AW issued**\n");
        for (String line : awLines) {
            sb.append(line);
            sb.append("\n");
        }
        sb.append("\n⛱️ **LOA**\n");
        for (String line : loaLines) {
            sb.append(line);
            sb.append("\n");
        }
        sb.append("\n👢 **Removed**\n");
        for (String line : removedLines) {
            sb.append(line);
            sb.append("\n");
        }
        sb.append("\n🚪 **Left**\n");
        for (String line : leftLines) {
            sb.append(line);
            sb.append("\n");
        }

        return sb.toString();
    }
}
