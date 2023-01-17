public class Arzt {
    int aktuelleBehandelungszeit;
    public Arzt() {
        
        
    }
    public void neuerPazient(int pBehandlungszeit){
        aktuelleBehandelungszeit=pBehandlungszeit;
    }
    public void behandlePazient(){
        
    }
    public boolean istFrei(){
        return aktuelleBehandelungszeit==0;
    }

}