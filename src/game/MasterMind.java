package game;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import util.Pair;

public class MasterMind {
	enum Color {
		R, G, B, Y
	}
	
	private Color[] colors;
		
	public MasterMind(Color[] colors){
		Objects.requireNonNull(colors);
		this.colors = colors;
	}
	
	public int getSlotNumber(){
		return colors.length;
	}
	
	public Pair<Integer> guess (Color[] guessed){
		Objects.requireNonNull(guessed);
		if (guessed.length != colors.length){
			throw new IllegalStateException("Wrong element number!");
		}
		
		int right = 0;
		int wrong = 0;
		
		//store already checked slots.
		Set<Integer> tmp = new HashSet<>();
		
		for (int i = 0; i< colors.length; i++){
			if (colors[i] == guessed[i]){
				right++;
				tmp.add(i);
			}
		}
		
		//store false matched slots.
		Set<Integer> tmp2 = new HashSet<>();
		for (int i = 0; i< colors.length; i++){
			//skip the matched
			if (!tmp.contains(i)){
				for (int j=0; j<colors.length; j++){
					if (i==j) continue;
					//skip the false matched
					if (!tmp2.contains(j)){
						if (colors[i] == guessed[j]){
							wrong++;
							tmp2.add(j);
							break;
						}
					}
				}
			}
		}
		
		return new Pair<Integer>(right, wrong);
	}
		
}
