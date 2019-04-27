package task8.facebookapps;

import java.util.concurrent.ThreadLocalRandom;

class BirthdayWishes {

    public static String getRandomWish() {
        int randomWithIndex = ThreadLocalRandom.current().nextInt(0, wishes.length);
        return wishes[randomWithIndex];
    }

    private static String[] wishes =
            {
                    "The joy is in the air because your special day is here!",
                    "Wishing my friend a very happy birthday and you don’t need to speak it out loud that I’m your best friend too. Love you, dear.",
                    "Thanks for being a wonderful son to me. I am so fortunate to have a fantastic son like you.",
                    "The years we shared while growing up are like treasures to me. I can remember our every moment of laughter. Happy Birthday, my dear friend.",
                    "Your birthday only comes once a year, so make sure this is the most memorable one ever and have a colorful day.",
                    "I gt a feeling that you’ll look really good when you get older. So don’t feel bad about how you look now. Happy birthday my friend!",
                    "I don’t have words to describe what I feel for you. Meeting you is the best thing that ever happened in my life. Happy Birthday!",
                    "Today I wish you a fun time, shared with your dear ones, and a lifelong happiness!",
                    "I always wished to be a great friend like you. But there is no way to be a better friend than you in the world. Happy birthday.",
                    "Wishing you a wonderful day and all the most amazing things on your Big Day!",
                    "You know all about me, I know all about you. We’re best friends, yada yada yada. Since we can read each other’s minds I don’t need a creative message.",
                    "Life is tough but birthdays are smooth because I will finally have a chance to smile at you. Happy birthday.",
                    "May your birthday be full of happy hours and special moments to remember for a long long time!",
                    "Soon you’re going to start a new year of your life and I hope this coming year will bring every success you deserve. Happy birthday.",
                    "Wishing you a memorable day and an adventurous year, Happy birthday",
                    "Hope your birthday is as wonderful and extraordinary as you are.",
                    "You are the only one who helped me a lot, guided me a lot and never given up when even I was not confident. Thanks for being all the way with me. Happy birthday.",
                    "I feel proud when I call you my sister. I want to feel this today and every day.",
                    "May the dream that means most to you, start coming true this year. Happy Bday!",
                    "May you enjoy your special day to the fullest extent, buddy!",
                    "With you, it is always about bringing in fun, in more ways than one, come rain come sun, just fun. Happy Birthday!",
                    "I wish a very happy birthday for the second much-loved child of my parents.",
                    "May your birthday mark the beginning of a wonderful period of time in your life!",
                    "My dear friend, may your special day be full of beautiful, magical and unforgettable moments!",
                    "Happy birthday, gorgeous! You are another year older and I just can’t see it. Have a blast! Wishing you the best of the best!",
                    "What did little birdie say?  Oh! It said it is your birthday today. Happy Birthday my love.",
                    "Wishing you greatest birthday ever, full of love and joy from the moment you open your eyes in the morning until you sleep for the night.",
                    "Mom, there is no one who can come even closer to your winning ways. Happy Birthday to my great mom.",
                    "I wish you to enjoy your special day, relax and let yourself be spoiled, you deserve it!",
                    "I wish you to have a wonderful time on your Day!",
                    "Wishing a happy birthday to the best person I’ve ever met in this world.",
                    "I wish that life brings you a beautiful surprise for every candle on your bday cake!",
                    "Hugging you don’t need any reason but, if there is a reason, more than one hug is a norm. Happy Birthday!",
                    "Thank you for all the memories we have. Without you, the world would have been colorless to me.",
                    "I wish you a day filled with great fun and a year filled with true happiness!",
                    "Let yourself do everything that you like most in life, may your Big Day be cheerful and happy!",
                    "Wishing you the abundance of fun and glory, Happy Birthday!",
                    "May this day be so happy that smile never fades away from your face.",
            };


}
