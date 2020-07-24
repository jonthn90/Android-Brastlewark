package xyz.jonthn.brastlewark.data

import xyz.jonthn.domain.Inhabitant as DomainInhabitant
import xyz.jonthn.brastlewark.data.server.Brastlewark as ServerInhabitant

fun ServerInhabitant.toDomainInhabitant(): DomainInhabitant =
    DomainInhabitant(age, friends, hair_color, height, id, name, professions, thumbnail, weight)