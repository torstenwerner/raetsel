package xyz.its_me.raetsel;

import lombok.Value;

@Value
class Pair<U, V> {
    U first;
    V second;
}
