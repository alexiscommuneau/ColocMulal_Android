package com.colocmulal.utils.mapper;

import com.colocmulal.core.error.exceptions.MappingException;

public interface UnsafeMapper<U, T> {
    T map(U toMap) throws MappingException;
}
