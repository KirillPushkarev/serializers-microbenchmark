/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class SerializationBenchmark {

    @Benchmark
    public void testSerializeToJson(BenchmarkState state, Blackhole blackhole) throws JsonProcessingException {
        String objectAsString = state.getObjectMapper().writeValueAsString(state.getPerson());
        blackhole.consume(objectAsString);
    }

    @Benchmark
    public void testDeserializeFromJson(BenchmarkState state, Blackhole blackhole) throws JsonProcessingException {
        Person person = state.getObjectMapper().readValue(state.getPersonJsonAsString(), Person.class);
        blackhole.consume(person);
    }

    @Benchmark
    public void testSerializeInProtoFormat(BenchmarkState state, Blackhole blackhole) {
        byte[] objectAsBytes = state.getPersonProto().toByteArray();
        blackhole.consume(objectAsBytes);
    }

    @Benchmark
    public void testDeserializeInProtoFormat(BenchmarkState state, Blackhole blackhole) throws InvalidProtocolBufferException {
        org.sample.protos.Person person = org.sample.protos.Person.parseFrom(state.getPersonProtoAsBytes());
        blackhole.consume(person);
    }
}
