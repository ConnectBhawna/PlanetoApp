package com.example.planetoland

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var planet:List<PlanetData>) :RecyclerView.Adapter<Adapter.myViewHolder>(){

    class myViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title = view.title
        var planetimg = view.planet_img
        var galaxy = view.galaxy
        var distance = view.distance
        var gravity = view.gravity

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.view,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage:Int?=null
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,PlanetDetails::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)

        }
        holder.title.text=planet[position].title
        holder.galaxy.text=planet[position].galaxy
        holder.distance.text=planet[position].distance+" m km"
        holder.gravity.text=planet[position].gravity+" m/ss"

        when(planet[position].title!!.toLowerCase()){

            "mars" -> {
                dummyImage=R.drawable.ic_mars
            }
            "neptune" -> {
                dummyImage=R.drawable.ic_neptune
            }
            "venus" -> {
                dummyImage=R.drawable.ic_venus
            }
            "uranus" -> {
                dummyImage=R.drawable.ic_uranus
            }
            "sun" -> {
                dummyImage=R.drawable.ic_sun
            }
            "saturn" -> {
                dummyImage=R.drawable.ic_saturn
            }
            "moon" -> {
                dummyImage=R.drawable.ic_moon
            }
            "mercury" -> {
                dummyImage=R.drawable.ic_mercury
            }
            "jupiter" -> {
                dummyImage=R.drawable.ic_jupiter
            }
            "earth" -> {
                dummyImage=R.drawable.ic_earth
            }

        }
        holder.planetimg.setImageResource(dummyImage!!)

    }

    override fun getItemCount(): Int {
        return planet.size
    }


}
