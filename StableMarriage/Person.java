package StableMarriage;

import java.util.*;

public class Person {
    
    private String name;
    private Person partner;
    private List<Person> candidates;
    private int candidateIndex;

    public List<Person> getCandidates() {
        return candidates;
    }

    public int getCandidateIndex() {
        return candidateIndex;
    }

    Person(String name) {
        this.name = name;
        this.partner = null;
        this.candidates = new ArrayList<>(); 
        this.candidateIndex = 0;
    }

    public void setCandidates(Person... candidates) {
        this.candidates.addAll(Arrays.asList(candidates));
    }

    public void setCandidateIndex(int candidateIndex) {
        this.candidateIndex = candidateIndex;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Person getPartner(){
        return this.partner;
    }
    public void setPartner(Person partner) {
        this.partner = partner;
    }
    
    /* get the prefered person from the available list */
    public Person getNext(){
        return (this.candidateIndex >= this.candidates.size()) ? null : this.candidates.get(this.candidateIndex++) ;
    }
    
    /* get the rank of a person */
    public int rank(Person p){
        for (int i = 0; i < this.candidates.size(); i++) {
            if(p == this.candidates.get(i)) return i;
        }
        return -1;
    }
    
    /* compare the partner and the person */
    public boolean prefers(Person p){
        return (this.rank(p) < this.rank(this.partner));
    }
    
    public void engageTo(Person p){
        if(p.partner != null) p.partner.partner = null;
        p.partner = this;
        if(this.partner != null) this.partner.partner = null;
        this.partner = p;
    }
}
