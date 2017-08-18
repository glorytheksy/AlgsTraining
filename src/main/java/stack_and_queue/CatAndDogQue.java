package stack_and_queue;

import java.util.LinkedList;

import utils.Cat;
import utils.Dog;
import utils.Pet;

public class CatAndDogQue {

    private LinkedList<Pet> list = new LinkedList<Pet>();
    
    private int size;
    
    private int catSize;
    
    private int dogSize;
    
    public void push(Pet pet) {
        list.add(pet);
        size++;
        if (pet.getType().equals("cat"))
            catSize++;
        if (pet.getType().equals("dog"))
            dogSize++;
    }
    
    public Pet poll() {
        if (0 == size){
            throw new RuntimeException();
        }
        
        if (this.peek().getType().equals("cat")){
            size--;
            catSize--;
            return list.removeFirst();
        }
        
        if (this.peek().getType().equals("dog")) {
            size--;
            dogSize--;
            return list.removeFirst();
        }
        
        else {
            size--;
            return list.removeFirst();
        }
    }
    
    public Pet peek() {
        if (0 == size){
            throw new RuntimeException();
        }        
        return list.getFirst();
    }
    
    public boolean isEmpty() {
        return 0 == size;
    }
    
    public boolean isCatEmpty() {
        return 0 == catSize;
    }
    
    public boolean isDogEmpty() {
        return 0 == dogSize;
    }
    
    public Cat pollCat(){
        if (0 == catSize) {
            throw new RuntimeException();
        }
        
        int pointer = 0;
        while(!list.get(pointer).getType().equals("cat")) {
            pointer++;
        }
        if (pointer > size){
            throw new RuntimeException();
        } else {
            catSize--;
            size--;
            return (Cat)list.remove(pointer);
        }
    }
    
    public Dog pollDog(){
        if (0 == dogSize) {
            throw new RuntimeException();
        }
        
        int pointer = 0;
        while(!list.get(pointer).getType().equals("dog")) {
            pointer++;
        }
        if (pointer > size){
            throw new RuntimeException();
        } else {
            dogSize--;
            size--;
            return (Dog)list.remove(pointer);
        }
    }
    
    public static void main(String[] args) {
        CatAndDogQue pq = new CatAndDogQue();
        pq.push(new Dog("dog1"));
        pq.push(new Cat("cat1"));
        pq.push(new Cat("cat2"));
        pq.push(new Dog("dog2"));
        pq.push(new Dog("dog3"));
        pq.push(new Cat("cat3"));
        pq.push(new Cat("cat4"));
        pq.push(new Pet("aPet"));
        pq.push(new Cat("cat5"));
        pq.push(new Dog("dog4"));
        pq.push(new Dog("dog5"));
        
        System.out.println(pq.pollCat().getName());
        System.out.println(pq.pollCat().getName());
        System.out.println(pq.pollCat().getName());
        
        System.out.println(pq.poll().getName());
        System.out.println(pq.poll().getName());
        System.out.println(pq.poll().getName());
        System.out.println(pq.poll().getName());
        System.out.println(pq.poll().getName());
        System.out.println(pq.poll().getName());
        System.out.println(pq.poll().getName());
        System.out.println(pq.poll().getName());
        
        
    }
    
}