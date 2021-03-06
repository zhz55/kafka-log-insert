// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO2

package ctitc.seagoing.SEAGOING



/** 车辆定位信息数据体
  *
  * @param encrypt
  *   加密标识
  * @param positionTime
  *   定位时间 
  * @param lon
  *   经度
  * @param lat
  *   纬度
  * @param vec1
  *   车载终端速度
  * @param vec2
  *   行驶记录速度
  * @param vec3
  *   总里程
  * @param direction
  *   方向
  * @param altitude
  *   海拔高度
  * @param state
  *   车辆状态
  * @param alarm
  *   报警状态
  */
@SerialVersionUID(0L)
final case class Gnss(
    encrypt: scala.Option[Int] = None,
    positionTime: String,
    lon: Int,
    lat: Int,
    vec1: scala.Option[Int] = None,
    vec2: scala.Option[Int] = None,
    vec3: scala.Option[Int] = None,
    direction: scala.Option[Int] = None,
    altitude: scala.Option[Int] = None,
    state: scala.Option[Int] = None,
    alarm: scala.Option[Int] = None
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[Gnss] with com.trueaccord.lenses.Updatable[Gnss] {
    @transient
    private[this] var __serializedSizeCachedValue: Int = 0
    private[this] def __computeSerializedValue(): Int = {
      var __size = 0
      if (encrypt.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, encrypt.get) }
      __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, positionTime)
      __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(3, lon)
      __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(4, lat)
      if (vec1.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(5, vec1.get) }
      if (vec2.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(6, vec2.get) }
      if (vec3.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(7, vec3.get) }
      if (direction.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(8, direction.get) }
      if (altitude.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(9, altitude.get) }
      if (state.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(10, state.get) }
      if (alarm.isDefined) { __size += _root_.com.google.protobuf.CodedOutputStream.computeUInt32Size(11, alarm.get) }
      __size
    }
    final override def serializedSize: Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): Unit = {
      encrypt.foreach { __v =>
        _output__.writeInt32(1, __v)
      };
      _output__.writeString(2, positionTime)
      _output__.writeUInt32(3, lon)
      _output__.writeUInt32(4, lat)
      vec1.foreach { __v =>
        _output__.writeUInt32(5, __v)
      };
      vec2.foreach { __v =>
        _output__.writeUInt32(6, __v)
      };
      vec3.foreach { __v =>
        _output__.writeUInt32(7, __v)
      };
      direction.foreach { __v =>
        _output__.writeUInt32(8, __v)
      };
      altitude.foreach { __v =>
        _output__.writeInt32(9, __v)
      };
      state.foreach { __v =>
        _output__.writeUInt32(10, __v)
      };
      alarm.foreach { __v =>
        _output__.writeUInt32(11, __v)
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): ctitc.seagoing.SEAGOING.Gnss = {
      var __encrypt = this.encrypt
      var __positionTime = this.positionTime
      var __lon = this.lon
      var __lat = this.lat
      var __vec1 = this.vec1
      var __vec2 = this.vec2
      var __vec3 = this.vec3
      var __direction = this.direction
      var __altitude = this.altitude
      var __state = this.state
      var __alarm = this.alarm
      var __requiredFields0: Long = 0x7L
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 8 =>
            __encrypt = Some(_input__.readInt32())
          case 18 =>
            __positionTime = _input__.readString()
            __requiredFields0 &= 0xfffffffffffffffeL
          case 24 =>
            __lon = _input__.readUInt32()
            __requiredFields0 &= 0xfffffffffffffffdL
          case 32 =>
            __lat = _input__.readUInt32()
            __requiredFields0 &= 0xfffffffffffffffbL
          case 40 =>
            __vec1 = Some(_input__.readUInt32())
          case 48 =>
            __vec2 = Some(_input__.readUInt32())
          case 56 =>
            __vec3 = Some(_input__.readUInt32())
          case 64 =>
            __direction = Some(_input__.readUInt32())
          case 72 =>
            __altitude = Some(_input__.readInt32())
          case 80 =>
            __state = Some(_input__.readUInt32())
          case 88 =>
            __alarm = Some(_input__.readUInt32())
          case tag => _input__.skipField(tag)
        }
      }
      if (__requiredFields0 != 0L) { throw new _root_.com.google.protobuf.InvalidProtocolBufferException("Message missing required fields.") } 
      ctitc.seagoing.SEAGOING.Gnss(
          encrypt = __encrypt,
          positionTime = __positionTime,
          lon = __lon,
          lat = __lat,
          vec1 = __vec1,
          vec2 = __vec2,
          vec3 = __vec3,
          direction = __direction,
          altitude = __altitude,
          state = __state,
          alarm = __alarm
      )
    }
    def getEncrypt: Int = encrypt.getOrElse(0)
    def clearEncrypt: Gnss = copy(encrypt = None)
    def withEncrypt(__v: Int): Gnss = copy(encrypt = Some(__v))
    def withPositionTime(__v: String): Gnss = copy(positionTime = __v)
    def withLon(__v: Int): Gnss = copy(lon = __v)
    def withLat(__v: Int): Gnss = copy(lat = __v)
    def getVec1: Int = vec1.getOrElse(0)
    def clearVec1: Gnss = copy(vec1 = None)
    def withVec1(__v: Int): Gnss = copy(vec1 = Some(__v))
    def getVec2: Int = vec2.getOrElse(0)
    def clearVec2: Gnss = copy(vec2 = None)
    def withVec2(__v: Int): Gnss = copy(vec2 = Some(__v))
    def getVec3: Int = vec3.getOrElse(0)
    def clearVec3: Gnss = copy(vec3 = None)
    def withVec3(__v: Int): Gnss = copy(vec3 = Some(__v))
    def getDirection: Int = direction.getOrElse(0)
    def clearDirection: Gnss = copy(direction = None)
    def withDirection(__v: Int): Gnss = copy(direction = Some(__v))
    def getAltitude: Int = altitude.getOrElse(0)
    def clearAltitude: Gnss = copy(altitude = None)
    def withAltitude(__v: Int): Gnss = copy(altitude = Some(__v))
    def getState: Int = state.getOrElse(0)
    def clearState: Gnss = copy(state = None)
    def withState(__v: Int): Gnss = copy(state = Some(__v))
    def getAlarm: Int = alarm.getOrElse(0)
    def clearAlarm: Gnss = copy(alarm = None)
    def withAlarm(__v: Int): Gnss = copy(alarm = Some(__v))
    def getFieldByNumber(__fieldNumber: Int): scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => encrypt.orNull
        case 2 => positionTime
        case 3 => lon
        case 4 => lat
        case 5 => vec1.orNull
        case 6 => vec2.orNull
        case 7 => vec3.orNull
        case 8 => direction.orNull
        case 9 => altitude.orNull
        case 10 => state.orNull
        case 11 => alarm.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => encrypt.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => _root_.scalapb.descriptors.PString(positionTime)
        case 3 => _root_.scalapb.descriptors.PInt(lon)
        case 4 => _root_.scalapb.descriptors.PInt(lat)
        case 5 => vec1.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 6 => vec2.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 7 => vec3.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 8 => direction.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 9 => altitude.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 10 => state.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 11 => alarm.map(_root_.scalapb.descriptors.PInt(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = ctitc.seagoing.SEAGOING.Gnss
}

object Gnss extends com.trueaccord.scalapb.GeneratedMessageCompanion[ctitc.seagoing.SEAGOING.Gnss] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[ctitc.seagoing.SEAGOING.Gnss] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): ctitc.seagoing.SEAGOING.Gnss = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    ctitc.seagoing.SEAGOING.Gnss(
      __fieldsMap.get(__fields.get(0)).asInstanceOf[scala.Option[Int]],
      __fieldsMap(__fields.get(1)).asInstanceOf[String],
      __fieldsMap(__fields.get(2)).asInstanceOf[Int],
      __fieldsMap(__fields.get(3)).asInstanceOf[Int],
      __fieldsMap.get(__fields.get(4)).asInstanceOf[scala.Option[Int]],
      __fieldsMap.get(__fields.get(5)).asInstanceOf[scala.Option[Int]],
      __fieldsMap.get(__fields.get(6)).asInstanceOf[scala.Option[Int]],
      __fieldsMap.get(__fields.get(7)).asInstanceOf[scala.Option[Int]],
      __fieldsMap.get(__fields.get(8)).asInstanceOf[scala.Option[Int]],
      __fieldsMap.get(__fields.get(9)).asInstanceOf[scala.Option[Int]],
      __fieldsMap.get(__fields.get(10)).asInstanceOf[scala.Option[Int]]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[ctitc.seagoing.SEAGOING.Gnss] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      ctitc.seagoing.SEAGOING.Gnss(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[scala.Option[Int]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).get.as[String],
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).get.as[Int],
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).get.as[Int],
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).flatMap(_.as[scala.Option[Int]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).flatMap(_.as[scala.Option[Int]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).flatMap(_.as[scala.Option[Int]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(8).get).flatMap(_.as[scala.Option[Int]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(9).get).flatMap(_.as[scala.Option[Int]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(10).get).flatMap(_.as[scala.Option[Int]]),
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(11).get).flatMap(_.as[scala.Option[Int]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = SEAGOINGProto.javaDescriptor.getMessageTypes.get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = SEAGOINGProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__fieldNumber)
  def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = ctitc.seagoing.SEAGOING.Gnss(
    positionTime = "",
    lon = 0,
    lat = 0
  )
  implicit class GnssLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, ctitc.seagoing.SEAGOING.Gnss]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, ctitc.seagoing.SEAGOING.Gnss](_l) {
    def encrypt: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getEncrypt)((c_, f_) => c_.copy(encrypt = Some(f_)))
    def optionalEncrypt: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.encrypt)((c_, f_) => c_.copy(encrypt = f_))
    def positionTime: _root_.com.trueaccord.lenses.Lens[UpperPB, String] = field(_.positionTime)((c_, f_) => c_.copy(positionTime = f_))
    def lon: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.lon)((c_, f_) => c_.copy(lon = f_))
    def lat: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.lat)((c_, f_) => c_.copy(lat = f_))
    def vec1: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getVec1)((c_, f_) => c_.copy(vec1 = Some(f_)))
    def optionalVec1: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.vec1)((c_, f_) => c_.copy(vec1 = f_))
    def vec2: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getVec2)((c_, f_) => c_.copy(vec2 = Some(f_)))
    def optionalVec2: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.vec2)((c_, f_) => c_.copy(vec2 = f_))
    def vec3: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getVec3)((c_, f_) => c_.copy(vec3 = Some(f_)))
    def optionalVec3: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.vec3)((c_, f_) => c_.copy(vec3 = f_))
    def direction: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getDirection)((c_, f_) => c_.copy(direction = Some(f_)))
    def optionalDirection: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.direction)((c_, f_) => c_.copy(direction = f_))
    def altitude: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getAltitude)((c_, f_) => c_.copy(altitude = Some(f_)))
    def optionalAltitude: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.altitude)((c_, f_) => c_.copy(altitude = f_))
    def state: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getState)((c_, f_) => c_.copy(state = Some(f_)))
    def optionalState: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.state)((c_, f_) => c_.copy(state = f_))
    def alarm: _root_.com.trueaccord.lenses.Lens[UpperPB, Int] = field(_.getAlarm)((c_, f_) => c_.copy(alarm = Some(f_)))
    def optionalAlarm: _root_.com.trueaccord.lenses.Lens[UpperPB, scala.Option[Int]] = field(_.alarm)((c_, f_) => c_.copy(alarm = f_))
  }
  final val ENCRYPT_FIELD_NUMBER = 1
  final val POSITIONTIME_FIELD_NUMBER = 2
  final val LON_FIELD_NUMBER = 3
  final val LAT_FIELD_NUMBER = 4
  final val VEC1_FIELD_NUMBER = 5
  final val VEC2_FIELD_NUMBER = 6
  final val VEC3_FIELD_NUMBER = 7
  final val DIRECTION_FIELD_NUMBER = 8
  final val ALTITUDE_FIELD_NUMBER = 9
  final val STATE_FIELD_NUMBER = 10
  final val ALARM_FIELD_NUMBER = 11
}
