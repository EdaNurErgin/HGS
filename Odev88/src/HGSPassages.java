public abstract class HGSPassages {
    String date;
    double fee;
    String exitGate;
    String entryGate;

    public HGSPassages(
                       String date, String exitGate, String entryGate, double fee) {

        this.date = date;
        this.exitGate = exitGate;
        this.entryGate = entryGate;
        this.fee = fee;
    }

    public void recordPassage(){
        System.out.println("Passage recorded on " + date + " from " + entryGate + " to " + exitGate + " with fee: " + fee);
    }
}
