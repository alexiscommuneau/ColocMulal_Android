package com.colocmulal.utils.mapper;

public interface Mapper<U, T> {
    T map(U toMap);
}
