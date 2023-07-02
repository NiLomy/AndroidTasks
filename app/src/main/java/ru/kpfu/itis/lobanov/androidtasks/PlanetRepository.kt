package ru.kpfu.itis.lobanov.androidtasks

object PlanetRepository {

    val list: List<Planet> = listOf(
        Planet(
            id = 1,
            name = "Mercury",
            desc = "The planet closest to the Sun. There is no water or air on Mercury. " +
                    "Due to the fact that Mercury is so close to the sun, the daytime " +
                    "temperature on this planet is almost +450 ° C.",
            url = "https://www.scienceabc.com/wp-content/uploads/2018/10/mercury.jpg"
        ),
        Planet(
            id = 2,
            name = "Venus",
            desc = "A planet that is often called the morning or evening star. These names " +
                    "are not accidental: Venus can be seen in the evening, in the rays of" +
                    " the setting Sun, or in the morning, just before sunrise. " +
                    "The surface of Venus is a plain strewn with rocks and fragments of rocks." +
                    " There is no water or life on Venus.",
            url = "https://i1.wp.com/cff2.earth.com/uploads/2021/10/13090040/Venus-scaled.jpg"
        ),
        Planet(
            id = 3,
            name = "Earth",
            desc = "It is almost 110 times smaller than this luminary in diameter." +
                    " Try to imagine that the Sun has turned into a melon. " +
                    "Then the earth with its huge cities, villages, mountains and seas " +
                    "would become the size of a small fruit pit.",
            url = "https://www.ejin.ru/wp-content/uploads/2017/09/6-1251.jpg"
        ),
        Planet(
            id = 4,
            name = "Mars",
            desc = "It is called the red planet because of the rust-red color of its surface." +
                    " The temperature on Mars is very low both during the day and at night.",
            url = "https://klike.net/uploads/posts/2023-01/1674455123_3-61.jpg"
        ),
        Planet(
            id = 5,
            name = "Jupiter",
            desc = "The largest planet in the Solar system. It is 1000 times larger" +
                    " than the Earth. Jupiter is located at a huge distance from the Sun," +
                    " which is why the temperature on this gas giant is -140 ° C.",
            url = "https://poisknews.ru/wp-content/uploads/2019/08/shutterstock_1191159922-1.jpg"
        ),
        Planet(
            id = 6,
            name = "Saturn",
            desc = "Externally, Saturn differs from the rest of the planets in that it is" +
                    " surrounded by many luminous rings. Each Saturn ring consists of" +
                    " even thinner rings. This \"decoration\" consists of billions of stone" +
                    " fragments covered with ice.",
            url = "https://dvacademy.ru/wp-content/uploads/2023/02/dvacademy-ru-p-saturn-vid-iz-kosmosa-krasivie-oboi-72.jpg"
        ),
        Planet(
            id = 7,
            name = "Uranus",
            desc = "It is 19 times farther away from the Sun than the Earth," +
                    " so it receives very little heat.",
            url = "https://cdnn21.img.ria.ru/images/07e5/02/0d/1597360648_0:56:1920:1136_1920x0_80_0_0_e765acc138a0c5a7f4a2b349533e33d6.jpg"
        ),
        Planet(
            id = 8,
            name = "Neptune",
            desc = "It is similar in appearance and size to Uranium." +
                    " It is highly compressed and rotates rapidly." +
                    "у Neptune is 2.8 billion kilometers away from the Sun.",
            url = "https://phonoteka.org/uploads/posts/2022-09/1663457027_4-phonoteka-org-p-neptun-art-krasivo-4.jpg"
        ),
    )
}