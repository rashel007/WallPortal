package tk.zedlabs.wallaperapp2019.ui

import android.R.attr
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_original_resolution.*
import tk.zedlabs.wallaperapp2019.R


class OriginalResolutionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_original_resolution)

        val i = intent
        val url = i.getStringExtra("imageUrl")

        Glide
            .with(this)
            .asBitmap()
            .load(url)
            .fitCenter()
            .listener(object : RequestListener<Bitmap?> {

                override fun onResourceReady( resource: Bitmap?,model: Any?,target:Target<Bitmap?>?,
                    dataSource: com.bumptech.glide.load.DataSource?,isFirstResource: Boolean): Boolean {
                    if (resource!=null){
                        val p: Palette = Palette.from(resource).generate()
                        or_res_cl.setBackgroundColor(p.getDarkVibrantColor(
                            ContextCompat.getColor(this@OriginalResolutionActivity, R.color.md_grey_600)))
                    }
                    return false
                }

                override fun onLoadFailed(e: GlideException?,model: Any?,target: Target<Bitmap?>?,isFirstResource: Boolean): Boolean {
                    return false
                }
            })
            .into(image_view_original)
    }
}
