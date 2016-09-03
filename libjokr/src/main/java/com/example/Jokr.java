package com.example;

import java.util.Random;

public class Jokr {
    String[] jokes = {
            "I would like to go on a diet. But i'm afraid my brain will get thinner & I will become narrow-minded.",
            "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.",
            "I want to die peacefully in my sleep, like my grandfather.. Not screaming and yelling like the passengers in his car.",
            "Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it.",
            "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.",
            "When wearing a bikini, women reveal 90 % of their body... men are so polite they only look at the covered parts.",
            "If I had a dollar for every girl that found me unattractive, they would eventually find me attractive.",
            "Apparently I snore so loudly that it scares everyone in the car I'm driving.",
            "Relationships are a lot like algebra. Have you ever looked at your X and wondered Y?",
            "My therapist says I have a preoccupation with vengeance. We'll see about that.",
            "Life is like toilet paper, you're either on a roll or taking shit from some asshole.",
            "Life is all about perspective. The sinking of the Titanic was a miracle to the lobsters in the ship's kitchen.",
            "I think my neighbor is stalking me as she's been googling my name on her computer. I saw it through my telescope last night.",
            "My wife and I were happy for twenty years. Then we met.",
            "I started out with nothing, and I still have most of it.",
            "If I ever need a heart transplant, I'd want my ex's. It's never been used.",
            "Is your ass jealous of the amount of shit that just came out of your mouth?",
            "You know that tingly little feeling you get when you like someone? That's your common sense leaving your body.",
            "Artificial intelligence is no match for natural stupidity.",
            "Money talks ...but all mine ever says is good-bye.",
            "That awkward moment when you leave a store without buying anything and all you can think is \"act natural, you're innocent\".",
            "Strong people don't put others down. They lift them up and slam them on the ground for maximum damage.",
            "I'm not saying I hate you, but I would unplug your life support to charge my phone.",
            "I'm great at multitasking. I can waste time, be unproductive, and procrastinate all at once.",
            "Isn't it great to live in the 21st century? Where deleting history has become more important than making it.",
            "Never laugh at your girlfriends choices... you're one of them.",
            "I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your password is incorrect\".",
            "I hate when I am about to hug someone really sexy and my face hits the mirror.",
            "You know you're ugly when it comes to a group picture and they hand you the camera.",
            "Childs experience: if a mother is laughing at the fathers jokes, it means they have guests.",
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness."
    } ;

    public String getJoke(int number){
        if(number >= jokes.length)
            return null;

        return jokes[number];
    }

    public String getJoke(){
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}
