public class NodeBT{
    NodeBT filhoD, filhoE;
    int tarefa;

    public NodeBT(int n){
        tarefa = n;
        filhoD = filhoE = null;
    }

    public void setFilhoD(NodeBT d){
        filhoD = d;
    }
    public void setFilhoE(NodeBT e){
        filhoE = e;
    }
    public void setTarefa(int n){
        tarefa = n;
    }
    public int getTarefa(){
        return tarefa;
    }
    public NodeBT getFilhoD(){
        return filhoD;
    }
    public NodeBT getFilhoE(){
        return filhoE;
    }
}
