package com.learning.myapplication.data

import com.learning.myapplication.Actors
import com.learning.myapplication.Movies
import com.learning.myapplication.R

class MovieData {
    companion object {
        fun generateMovies(): List<Movies> {
            val movieList = mutableListOf<Movies>()

            movieList.add(
                Movies(
                    R.drawable.avengers,
                    pg_age = "13+",
                    genre = "Action, Adventure",
                    rating = 4,
                    reviews = "125",
                    title = "Avengers: End Game",
                    duration = "137 MIN",
                    description = "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\\' actions and restore balance to the universe.",
                    actors = listOf(
                        Actors("Robert Downey Jr.", R.drawable.robert_downey),
                        Actors("Chris Evans", R.drawable.person2),
                        Actors("Mark Rufallo", R.drawable.person3),
                        Actors("Chris Hemsworth", R.drawable.person4)
                    )
                )
            )
            movieList.add(
                Movies(
                    R.drawable.black_widow,
                    pg_age = "12+",
                    genre = "Action, Adventure, Sci-Fi",
                    rating = 3,
                    reviews = "100",
                    title = "Black Widow",
                    duration = "160 MIN",
                    description = "At birth the Black Widow \"aka Natasha Romanova\" is given to the KGB, which grooms her to become its ultimate operative. When the U.S.S.R. breaks up, the government tries to kill her as the action moves to present-day New York, where she is a freelance operative.",
                    actors = listOf(
                        Actors("Robert Downey Jr.", R.drawable.robert_downey),
                        Actors("Florence Pugh", R.drawable.florence_pugh),
                        Actors("Scarlett Johansson", R.drawable.scarlett_johansson),
                        Actors("Kevin Feigh", R.drawable.kevin_feige),
                        Actors("Yolanda Lynes", R.drawable.yolanda_lynes),
                        Actors("O. T. Fagbenle", R.drawable.o_t_fagbenle)
                    )
                )
            )
            movieList.add(
                Movies(
                    R.drawable.tenet,
                    pg_age = "16+",
                    genre = "Action, Sci-Fi",
                    rating = 4,
                    reviews = "450",
                    title = "Tenet",
                    duration = "150 MIN",
                    description = "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                    actors = listOf(
                        Actors("Jefferson Hall", R.drawable.jefferson_hall),
                        Actors("Juhan Ulfsak", R.drawable.juhan_ulfsak),
                        Actors("John David Washington", R.drawable.john_david_washington),
                        Actors("Clemence Poesy", R.drawable.clemence_poesy),
                        Actors("Wes Chatham", R.drawable.weschatham)
                    )
                       )
            )
            movieList.add(
                Movies(
                    R.drawable.bird_box,
                    pg_age = "13+",
                    genre = "Horror, Sci-Fi",
                    rating = 3,
                    reviews = "717",
                    title = "Bird Box",
                    duration = "124 MIN",
                    description = "In the wake of an unknown global terror, a mother must find the strength to flee with her children down a treacherous river in search of safety. Due to unseen deadly forces, the perilous journey must be made blindly. Directed by Emmy winner Susanne Bier, Bird Box is a thriller starring Academy Award winner Sandra Bullock, John Malkovich, Sarah Paulson, and Trevante Rhodes",
                    actors = listOf(
                        Actors("Sandra Bullock", R.drawable.sandra_bullock),
                        Actors("Trevante Rhodes", R.drawable.trevante_hodes),
                        Actors("John Malkovich", R.drawable.john_malkovich),
                        Actors("Sarah Paulson", R.drawable.sarah_paulson),
                        Actors("Rosa Salazar", R.drawable.rosa_salazar)
                    )
                       )
            )
            movieList.add(
                Movies(
                    R.drawable.ford_ferrary,
                    pg_age = "16+",
                    genre = "Action, Biography, Drama",
                    rating = 2,
                    reviews = "102",
                    title = "Ford v Ferrari",
                    duration = "152 MIN",
                    description = "As Enzo Ferrari's fast Rosso-Corsa racing cars dominate the mid-1960s motorsport world, the American car designer, Carroll Shelby, is forced to retire after winning the demanding 1959 '24 Hours of Le Mans' endurance race. But, before long, an unexpected proposition by the Vice President of Henry Ford's motor company, Lee Iacocca, will offer an opportunity to beat the Italians at their own game. Now, under those pressing circumstances, the British sports car driver and racing engineer, Ken Miles, reluctantly agrees to lend a hand and improve the firm's image, as Ford's race team has less than ninety days to rewrite history. As a result, the non-conformist duo comes up with the mighty Ford GT40 Mk I high-performance racing car. Can Shelby and Miles break Ferrari's streak?",
                    actors = listOf(
                        Actors("Matt Damon", R.drawable.matt_damon),
                        Actors("Christian Bale", R.drawable.christian_bale),
                        Actors("Jon Bernthal", R.drawable.jon_bernthal),
                        Actors("Caitriona Balfe", R.drawable.caitriona_balfe),
                        Actors("Josh Lucas", R.drawable.josh_lucas)
                    )
                       )
            )
            movieList.add(
                Movies(
                    R.drawable.avatar,
                    pg_age = "12+",
                    genre = "Action, Adventure, Fantasy",
                    rating = 4,
                    reviews = "1028",
                    title = "Avatar",
                    duration = "162 MIN",
                    description = "When his brother is killed in a robbery, paraplegic Marine Jake Sully decides to take his place in a mission on the distant world of Pandora. There he learns of greedy corporate figurehead Parker Selfridge's intentions of driving off the native humanoid \"Na'vi\" in order to mine for the precious material scattered throughout their rich woodland. In exchange for the spinal surgery that will fix his legs, Jake gathers knowledge, of the Indigenous Race and their Culture, for the cooperating military unit spearheaded by gung-ho Colonel Quaritch, while simultaneously attempting to infiltrate the Na'vi people with the use of an \"avatar\" identity. While Jake begins to bond with the native tribe and quickly falls in love with the beautiful alien Neytiri, the restless Colonel moves forward with his ruthless extermination tactics, forcing the soldier to take a stand - and fight back in an epic battle for the fate of Pandora.",
                    actors = listOf(
                        Actors("Sam Worthington", R.drawable.sam_worthington),
                        Actors("Zoe Saldana", R.drawable.zoe_saldana),
                        Actors("Stephen Lang ", R.drawable.stephen_lang),
                        Actors("Michelle Rodriguez", R.drawable.michelle_rodriguez)
                    )
                       )
            )
            movieList.add(
                Movies(
                    R.drawable.san_andreas,
                    pg_age = "13+",
                    genre = " Action, Adventure, Thriller",
                    rating = 3,
                    reviews = "211",
                    title = "San Andreas",
                    duration = "162 MIN",
                    description = "In San Andreas, California is experiencing a statewide earthquake that goes on record as easily the biggest earthquake in history. Dwayne Johnson plays Ray Gaines, a helicopter rescue pilot for the Los Angeles Fire Department, who is trying to find his daughter, Blake (Alexandra Daddario), who is in San Francisco amid-st the chaos. Ray's estranged wife, Emma, is forced to turn to Ray for help, as he is her last resort. Together they journey to save their daughter.",
                    actors = listOf(
                        Actors("Dwayne Johnson", R.drawable.dwayne_johnson),
                        Actors("Carla Gugino", R.drawable.carla_gugino),
                        Actors("Alexandra Daddario", R.drawable.alexandra_daddario),
                        Actors("Ioan Gruffudd", R.drawable.ioan_gruffudd)
                    )
                       )
            )

            return movieList
        }
    }
}