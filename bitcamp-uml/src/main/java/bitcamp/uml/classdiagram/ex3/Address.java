package bitcamp.uml.classdiagram.ex3;


public class Address {
    String postNo;
    String basicAddr;
    String detailAddr;

    public Address(String postno,
                   String basicAddr,
                   String datailAddr) {
        this.postNo = postno;
        this.basicAddr = basicAddr;
        this.detailAddr = datailAddr;
    }
}
