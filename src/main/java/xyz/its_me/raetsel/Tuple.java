package xyz.its_me.raetsel;

import lombok.Value;

@Value
class Tuple<U, V, W> {
    U first;
    V second;
    W third;
}
