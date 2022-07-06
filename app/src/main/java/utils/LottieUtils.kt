package utils

import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieCompositionFactory

class LottieUtils {

    fun loadFromAssets(view: LottieAnimationView) {
        LottieCompositionFactory.fromAsset(view.context, "vs.zip").addListener{ result->
            view.setComposition(result)
            view.playAnimation()
        }
    }

}