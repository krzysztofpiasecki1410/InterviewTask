import java.util.ArrayList;
import java.util.List;

public class TextRowRepresentation {
    private Integer amountOfAppearances;
    private List<Integer> linePositions;

    public TextRowRepresentation(Integer lineNumber) {
        amountOfAppearances = 1;
        linePositions = new ArrayList<>();
        linePositions.add(lineNumber);
    }

    public Integer getAmountOfAppearances() {
        return amountOfAppearances;
    }

    public void setAmountOfAppearances(Integer amountOfAppearances) {
        this.amountOfAppearances = amountOfAppearances;
    }

    public List<Integer> getLinePositions() {
        return linePositions;
    }

    public void setLinePositions(List<Integer> linePositions) {
        this.linePositions = linePositions;
    }
    public void increaseAmountOfApearances() {
        amountOfAppearances += 1;
    }
    public void addAnotherLinePosition(Integer position) {
        linePositions.add(position);
    }

    @Override
    public String toString() {
        return amountOfAppearances + " - " + " pozycje -> " + linePositions;
    }
}
