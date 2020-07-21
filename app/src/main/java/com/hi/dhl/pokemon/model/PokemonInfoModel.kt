/*
 * Copyright 2020. hi-dhl (Jack Deng)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hi.dhl.pokemon.model

import kotlin.random.Random

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/11
 *     desc  :
 * </pre>
 */
data class PokemonInfoModel(
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
//    val types: List<Types>,
//    val stats: List<Stats>,
//    val sprites: Sprites,
    val hp: Int = Random.nextInt(maxHp),
    val attack: Int = Random.nextInt(maxAttack),
    val speed: Int = Random.nextInt(maxSpeed),
    val exp: Int = Random.nextInt(maxExp)
) {

    fun generatetWeight(): String = "%.1f KG".format(weight.toFloat() / 10)
    fun generateHeight(): String = "%.1f M".format(height.toFloat() / 10)
    fun generatetHP(): String = "$hp/$maxHp HP"
    fun generatetAttack(): String = "$attack/$maxAttack"
    fun generatetSpeed(): String = "$speed/$maxSpeed"
    fun generatetExp(): String = "$exp/$maxExp"

    override fun toString(): String {
        return "PokemonInfoModel(name='$name', height=$height, weight=$weight, experience=$experience)"
    }

    data class Sprites(
        val backDefault: String,
        val backFemale: String,
        val backShiny: String,
        val backShinyFemale: String,
        val frontDefault: String,
        val frontfemale: String,
        val frontShiny: String,
        val frontShinyFemale: String
    )

    data class Types(val slot: Int, val type: Type) {
        data class Type(val name: String, val url: String)
    }

    data class Stats(val baseStat: Int, val stat: Stat) {
        data class Stat(val name: String, val url: String)
    }

    companion object {
        const val maxHp = 500
        const val maxAttack = 600
        const val maxSpeed = 400
        const val maxExp = 800
    }
}