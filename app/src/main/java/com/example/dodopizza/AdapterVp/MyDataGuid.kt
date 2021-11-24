package com.example.dodopizza.AdapterVp

import com.example.dodopizza.R

data class MyDataGuid(val title:String, val descr:String,val image:Int)

data class user(val userId: String,
                 val firstName: String,
                 val lastName: String,
                 val email: String,
                 val avatar: String)


object List{
        val list = arrayListOf(
            MyDataGuid("Быстрая доставка!", "Гарантируем доставку не более чем за 60 минут с момента приема заказа. Если курьеры не успеют, вы получите сертификат на большую бесплатную пиццу с доставкой. ",
                R.drawable.ic_one),
            MyDataGuid("Идеальные ингредиенты!", "Почему мы так хотим познакомиться? Потому что дальше пицца делает всё сама. Люди видят, что она вкусная, и возвращаются снова. Нам главное первый раз это показать.",R.drawable.ic_two
        ),
            MyDataGuid("Почему Додо?","Знаете почему мы называемся в честь этой странной птицы? Додо, или маврикийские дронты, были очень доверчивыми и наивными, и вымерли в конце семнадцатого века с приходом колонизаторов",R.drawable.ic_three))
    }

