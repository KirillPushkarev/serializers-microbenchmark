// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: resources/person.proto

package org.sample.protos;

public final class PersonProtos {
  private PersonProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sample_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sample_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sample_Person_PhoneNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sample_Person_PhoneNumber_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026resources/person.proto\022\006sample\"\327\001\n\006Per" +
      "son\022\014\n\004name\030\001 \001(\t\022\n\n\002id\030\002 \001(\005\022\r\n\005email\030\003" +
      " \001(\t\022*\n\006phones\030\004 \003(\0132\032.sample.Person.Pho" +
      "neNumber\032K\n\013PhoneNumber\022\016\n\006number\030\001 \001(\t\022" +
      ",\n\004type\030\002 \001(\0162\030.sample.Person.PhoneType:" +
      "\004HOME\"+\n\tPhoneType\022\n\n\006MOBILE\020\000\022\010\n\004HOME\020\001" +
      "\022\010\n\004WORK\020\002B#\n\021org.sample.protosB\014PersonP" +
      "rotosP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sample_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sample_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sample_Person_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "Phones", });
    internal_static_sample_Person_PhoneNumber_descriptor =
      internal_static_sample_Person_descriptor.getNestedTypes().get(0);
    internal_static_sample_Person_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sample_Person_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
